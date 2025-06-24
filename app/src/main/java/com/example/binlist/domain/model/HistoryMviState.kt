package com.example.binlist.domain.model

data class HistoryMviState(
    val history: List<BinInfoUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

