package com.example.binlist.presentation.ui.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.domain.model.HistoryMviState
import com.example.binlist.domain.repository.BinInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repo: BinInfoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HistoryMviState())
    val state: StateFlow<HistoryMviState> = _state

    init {
        viewModelScope.launch {
            repo.getHistory().collect { list ->
                _state.update { it.copy(history = list) }
            }
        }
    }
}

