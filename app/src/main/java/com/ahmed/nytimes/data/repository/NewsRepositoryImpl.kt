package com.ahmed.nytimes.data.repository

import android.util.Log
import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.repository.dataSorce.NewsRemoteDataSource
import com.ahmed.nytimes.data.utils.Resource
import com.ahmed.nytimes.domain.NewsRepository
import okio.IOException

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource) : NewsRepository {

    override suspend fun getNewsFromApis(): Resource<List<MostPopularModel>> {

        return try {
            Log.d(
                "Ahmed123",
                "getNewsFromApisImpl: "
            )
            if (newsRemoteDataSource.getNewsFromApis().isSuccessful){
//                newsModelList=newsRemoteDataSource.getNewsFromApis().body()!!.results
                Resource.Success(newsRemoteDataSource.getNewsFromApis().body()!!.results)
            }else{
                Log.d("Ahmed123", "getNewsFromApisErrorELse:")

                Resource.Error(newsRemoteDataSource.getNewsFromApis().message())
            }



        } catch (e: IOException) {
            Log.d("Ahmed123", "getNewsFromApisIOError: ${e.message}")
            Resource.Error(e.message!!)

        } catch (e: Exception) {
            Log.d("Ahmed123", "getNewsFromApisError: ${e.message}")
            Resource.Error(e.message!!)

        }
    }
}