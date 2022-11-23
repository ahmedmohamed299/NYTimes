package com.ahmed.nytimes.presentation.di

import com.ahmed.nytimes.data.apis.NewsApis
import com.ahmed.nytimes.data.repository.dataSorce.NewsRemoteDataSource
import com.ahmed.nytimes.data.repository.dataSorceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsApis: NewsApis): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApis)
    }
}