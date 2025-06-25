package com.example.binlist.domain.useCase

import com.example.binlist.domain.model.BinInfoUiModel
import com.example.binlist.domain.repository.BinListApi
import com.example.binlist.utils.ext.toUiModel
import javax.inject.Inject

/**
 * Requests are throttled at 5 per hour with a burst allowance of 5.
 * If you hit the speed limit the service will return a 429 http status code.
 * */

class GetBinInfoUseCase @Inject constructor(
    private val api: BinListApi
) {
    suspend operator fun invoke(bin: String): BinInfoUiModel {
        if (bin.length < 6) throw IllegalArgumentException("Минимум 6 цифр для BIN/IIN.")

        return api.getBinInfo(bin).toUiModel()
    }
}

