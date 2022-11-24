package com.ahmed.nytimes.data.repository

import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.repository.dataSorce.NewsRemoteDataSource
import com.ahmed.nytimes.data.utils.Resource
import com.ahmed.nytimes.domain.NewsRepository
import okio.IOException

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource) : NewsRepository {

    override suspend fun getNewsFromApis(): Resource<List<MostPopularModel>> {

        return try {

            if (newsRemoteDataSource.getNewsFromApis().isSuccessful){
                Resource.Success(newsRemoteDataSource.getNewsFromApis().body()!!.results)
            }else{

                Resource.Error(newsRemoteDataSource.getNewsFromApis().message())
            }



        } catch (e: IOException) {
            Resource.Error(e.message!!)

        } catch (e: Exception) {
            Resource.Error(e.message!!)

        }
    }
}