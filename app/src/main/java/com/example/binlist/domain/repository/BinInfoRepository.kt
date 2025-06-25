package com.example.binlist.domain.repository

import com.example.binlist.data.BinInfoDao
import com.example.binlist.domain.model.BinInfoUiModel
import com.example.binlist.utils.ext.toEntity
import com.example.binlist.utils.ext.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BinInfoRepository @Inject constructor(
    private val dao: BinInfoDao
) {
    fun getHistory(): Flow<List<BinInfoUiModel>> = dao.getAll().map { list ->
        list.map { it.toUiModel() }
    }

    suspend fun insert(bin: String, model: BinInfoUiModel) {
        dao.insert(model.toEntity(bin))
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}
