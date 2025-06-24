package com.example.binlist.domain.model

data class BinInfoUiModel(
    val scheme: String,
    val type: String,
    val brand: String?,
    val countryName: String,
    val latitude: Double?,
    val longitude: Double?,
    val bankName: String,
    val bankPhone: String?,
    val bankUrl: String?,
    val bankCity: String?
)
