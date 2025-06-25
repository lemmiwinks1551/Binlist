package com.example.binlist.di

import android.content.Context
import androidx.room.Room
import com.example.binlist.data.BinDatabase
import com.example.binlist.data.BinInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BinDatabase {
        return Room.databaseBuilder(
            context,
            BinDatabase::class.java,
            "bin_info_db"
        ).build()
    }

    @Provides
    fun provideDao(db: BinDatabase): BinInfoDao = db.binInfoDao()
}
