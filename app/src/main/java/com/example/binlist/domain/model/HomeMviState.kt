package com.example.binlist.domain.model

data class HomeMviState(
    val inputBin: String = "",
    val binInfo: BinInfoUiModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
