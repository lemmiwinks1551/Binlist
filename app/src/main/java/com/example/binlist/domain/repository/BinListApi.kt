package com.example.binlist.domain.repository

import com.example.binlist.domain.model.BinInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApi {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoDto
}
