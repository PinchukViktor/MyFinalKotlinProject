package com.example.finalproject.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.domain.CatUseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {
    private val animalUseCase = CatUseCase
    val factsFromApi = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getFactsOfCat() {
        viewModelScope.launch {

            isLoading.postValue(true)

            val facts = animalUseCase.getFact()
            factsFromApi.postValue(facts)

            isLoading.postValue(false)
        }

    }

}