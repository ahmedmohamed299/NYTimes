package com.ahmed.nytimes.domain

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNewsFromApisUseCaseTest{
    private lateinit var newsRepositoryTest: NewsRepositoryTest
    private lateinit var getNewsFromApisUseCase: GetNewsFromApisUseCase

    @Before
    fun setUp() {
        newsRepositoryTest = NewsRepositoryTest()
        getNewsFromApisUseCase= GetNewsFromApisUseCase(newsRepositoryTest)

    }

    @Test
    fun `get all news , correct data`():Unit= runBlocking {
        //when
        val news = getNewsFromApisUseCase.execute().data
        //then
        assertThat(news!![0].byline == "By Dave Philipps").isTrue()
    }
}