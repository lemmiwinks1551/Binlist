package com.example.binlist.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.domain.model.HomeMviState
import com.example.binlist.domain.repository.BinInfoRepository
import com.example.binlist.domain.useCase.GetBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: BinInfoRepository,
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeMviState())
    val state: StateFlow<HomeMviState> = _state

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(inputBin = "491957") }
            }
        }
    }

    fun onBinChanged(newBin: String) {
        _state.update { it.copy(inputBin = newBin) }
    }

    fun onSearchClicked() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }

            val bin = _state.value.inputBin

            runCatching {
                val result = getBinInfoUseCase(bin)
                bin to result
            }.onSuccess { (bin, result) ->
                _state.update { it.copy(binInfo = result, isLoading = false) }
                repository.insert(bin, result)
            }.onFailure { error ->
                _state.update {
                    it.copy(
                        errorMessage = error.message ?: "Что-то пошло не так",
                        isLoading = false
                    )
                }
            }
        }
    }
}