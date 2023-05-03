package com.example.finalproject.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.CatDataClass
import com.example.finalproject.data.local.CatDataBase
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    var vmData = ArrayList<CatDataClass>()

}

