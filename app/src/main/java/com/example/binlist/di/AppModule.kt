package com.example.binlist.di

import com.example.binlist.domain.repository.BinListApi
import com.example.binlist.domain.useCase.GetBinInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule
