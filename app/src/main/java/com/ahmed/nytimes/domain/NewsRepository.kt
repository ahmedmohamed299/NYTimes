package com.ahmed.nytimes.domain

import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.utils.Resource

interface NewsRepository {
    suspend fun getNewsFromApis():Resource<List<MostPopularModel>>
}