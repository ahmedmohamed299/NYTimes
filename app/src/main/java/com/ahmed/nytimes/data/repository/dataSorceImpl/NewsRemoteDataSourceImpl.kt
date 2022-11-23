package com.ahmed.nytimes.data.repository.dataSorceImpl

import com.ahmed.nytimes.data.apis.NewsApis
import com.ahmed.nytimes.data.model.MostPopularResponse
import com.ahmed.nytimes.data.repository.dataSorce.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsApis: NewsApis):NewsRemoteDataSource {
    override suspend fun getNewsFromApis(): Response<MostPopularResponse> =newsApis.getNews()
}