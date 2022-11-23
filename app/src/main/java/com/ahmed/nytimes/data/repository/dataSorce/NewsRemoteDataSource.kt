package com.ahmed.nytimes.data.repository.dataSorce

import com.ahmed.nytimes.data.model.MostPopularResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsFromApis():Response<MostPopularResponse>
}