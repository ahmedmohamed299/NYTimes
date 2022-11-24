package com.ahmed.nytimes.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.utils.Resource
import com.ahmed.nytimes.domain.GetNewsFromApisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsFromApisUseCase: GetNewsFromApisUseCase
) :
    ViewModel() {

    private var newsMutableLiveData = MutableLiveData<Resource<List<MostPopularModel>>>()

    fun getNewsFromApis(): LiveData<Resource<List<MostPopularModel>>> {

        newsMutableLiveData.postValue(Resource.Loading())

        try {


            viewModelScope.launch(Dispatchers.IO) {


                newsMutableLiveData.postValue(getNewsFromApisUseCase.execute())




            }
        } catch (e: Exception) {
            newsMutableLiveData.postValue(Resource.Error(e.message!!))

        }



        return newsMutableLiveData
    }
}