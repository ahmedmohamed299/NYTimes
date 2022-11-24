package com.ahmed.nytimes.data

import com.ahmed.nytimes.data.apis.NewsApis
import com.ahmed.nytimes.data.utils.Constants
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApisTest {
    private lateinit var service: NewsApis
    private lateinit var server: MockWebServer
    private val path = "7.json?api-key=${Constants.API_KEY}"


    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApis::class.java)


    }


    private fun enqueueMockResponse(
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream("newsresponse.json")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getNews_sentRequest_receivedExpected() = runBlocking {
        //given
        enqueueMockResponse()
        val request = server.takeRequest()
        //when
        val responseBody = service.getNews().body()
        //then
        assertThat(responseBody).isNotNull()
        assertThat(request.path).isEqualTo(path)


    }


    @Test
    fun getNews_receivedResponse_correctPageSize() = runBlocking {
        //given
        enqueueMockResponse()
        val responseBody = service.getNews().body()
        //when
        val number = responseBody!!.num_results
        //then
        assertThat(number).isEqualTo(20)

    }


    @Test
    fun getTopHeadlines_receivedResponse_correctContent() = runBlocking {
        //given
        enqueueMockResponse()
        val responseBody = service.getNews().body()
        //when
        val result = responseBody!!.results
        val news = result[0]
        //then
        assertThat(news.byline).isEqualTo("By Mike Baker and Nicholas Bogel-Burroughs")
        assertThat(news.title).isEqualTo("1,000 Tips, No Suspects: Latest on the University of Idaho Killings")
        assertThat(news.published_date).isEqualTo("2022-11-19")


    }


    @After
    fun tearDown() {
        server.shutdown()
    }
}