package com.ahmed.nytimes.presentation.di

import com.ahmed.nytimes.domain.GetNewsFromApisUseCase
import com.ahmed.nytimes.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsFromApisUseCase(newsRepository: NewsRepository): GetNewsFromApisUseCase {
        return GetNewsFromApisUseCase(newsRepository)
    }


}