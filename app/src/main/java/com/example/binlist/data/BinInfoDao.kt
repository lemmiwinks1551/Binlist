package com.example.binlist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binlist.domain.model.BinInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BinInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(binInfo: BinInfoEntity)

    @Query("SELECT * FROM bin_info_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<BinInfoEntity>>

    @Query("DELETE FROM bin_info_history")
    suspend fun deleteAll()
}
