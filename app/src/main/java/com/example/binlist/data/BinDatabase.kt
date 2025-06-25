package com.example.binlist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binlist.domain.model.BinInfoEntity

@Database(
    entities = [BinInfoEntity::class],
    version = 1
)
abstract class BinDatabase : RoomDatabase() {
    abstract fun binInfoDao(): BinInfoDao
}
