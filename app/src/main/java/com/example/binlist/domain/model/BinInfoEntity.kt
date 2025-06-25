package com.example.binlist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_info_history")
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bin: String,
    val scheme: String,
    val type: String,
    val brand: String?,
    val countryName: String,
    val latitude: Double?,
    val longitude: Double?,
    val bankName: String,
    val bankPhone: String?,
    val bankUrl: String?,
    val bankCity: String?,
    val timestamp: Long = System.currentTimeMillis()
)
