package com.ahmed.nytimes.presentation.ui

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahmed.nytimes.domain.GetNewsFromApisUseCase
import com.ahmed.nytimes.domain.NewsRepositoryTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NewsViewModelTest {

    private lateinit var newsRepositoryTest: NewsRepositoryTest
    private lateinit var getNewsFromApisUseCase: GetNewsFromApisUseCase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        newsRepositoryTest = NewsRepositoryTest()
        getNewsFromApisUseCase = GetNewsFromApisUseCase(newsRepositoryTest)

    }

    @Test
    fun getNewsFromApis():Unit= runBlocking {
        //given
        val newsList = getNewsFromApisUseCase.execute().data
        //when

        //then
        assertThat(newsList!![0].id == 100000008649420).isTrue()
    }


}