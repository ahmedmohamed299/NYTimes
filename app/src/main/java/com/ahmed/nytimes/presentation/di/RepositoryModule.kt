package com.ahmed.nytimes.presentation.di

import com.ahmed.nytimes.data.repository.NewsRepositoryImpl
import com.ahmed.nytimes.data.repository.dataSorce.NewsRemoteDataSource
import com.ahmed.nytimes.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }

}