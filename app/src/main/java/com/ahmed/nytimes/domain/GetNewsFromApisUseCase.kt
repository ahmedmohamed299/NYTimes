package com.ahmed.nytimes.domain

import android.util.Log
import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.utils.Resource
class GetNewsFromApisUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute():Resource<List<MostPopularModel>> {
      return newsRepository.getNewsFromApis()
    }
}

