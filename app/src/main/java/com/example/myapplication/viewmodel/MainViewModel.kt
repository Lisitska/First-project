package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.UniversityApi
import com.example.myapplication.repository.MainRepository
import com.example.myapplication.view.main.UniversityInfo
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(private val mainRepository: MainRepository = MainRepository()) : ViewModel() {

    private val _universityList = MutableLiveData<List<UniversityInfo>?>().apply {
        viewModelScope.launch {
            mainRepository.universityList.collect {
                value = it
            }
        }
    }
        val universityList: LiveData<List<UniversityInfo>?> = _universityList
    }