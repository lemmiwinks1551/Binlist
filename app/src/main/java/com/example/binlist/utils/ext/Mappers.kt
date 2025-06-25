package com.example.binlist.utils.ext

import com.example.binlist.domain.model.BinInfoDto
import com.example.binlist.domain.model.BinInfoEntity
import com.example.binlist.domain.model.BinInfoUiModel

fun BinInfoEntity.toUiModel() = BinInfoUiModel(
    scheme, type, brand, countryName, latitude, longitude,
    bankName, bankPhone, bankUrl, bankCity
)

fun BinInfoUiModel.toEntity(bin: String) = BinInfoEntity(
    bin = bin,
    scheme = scheme,
    type = type,
    brand = brand,
    countryName = countryName,
    latitude = latitude,
    longitude = longitude,
    bankName = bankName,
    bankPhone = bankPhone,
    bankUrl = bankUrl,
    bankCity = bankCity
)

fun BinInfoDto.toUiModel(): BinInfoUiModel {
    return BinInfoUiModel(
        scheme = scheme ?: "Unknown",
        type = type ?: "Unknown",
        brand = brand,
        countryName = country?.name ?: "Unknown",
        latitude = country?.latitude,
        longitude = country?.longitude,
        bankName = bank?.name ?: "Unknown",
        bankPhone = bank?.phone,
        bankUrl = bank?.url,
        bankCity = bank?.city
    )
}

