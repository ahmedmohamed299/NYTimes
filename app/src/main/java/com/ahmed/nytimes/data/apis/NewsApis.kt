package com.ahmed.nytimes.data.apis

import com.ahmed.nytimes.data.model.MostPopularResponse
import com.ahmed.nytimes.data.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApis {

    @GET("7.json")
    suspend fun getNews(@Query("api-key") api:String=Constants.API_KEY):Response<MostPopularResponse>
}