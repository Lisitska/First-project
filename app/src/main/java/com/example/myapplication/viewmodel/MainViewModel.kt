package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.repository.MainRepository
import com.example.myapplication.view.main.ShopInfo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel (private val mainRepository: MainRepository = MainRepository()): ViewModel() {

    private val _shopList =  MutableLiveData<List<ShopInfo>?>().apply {
        viewModelScope.launch {
            mainRepository.
            shopList.
            collect {
                if (it != null) {
                    value = it
                }
            }
        }
    }

    val shopList: LiveData<List<ShopInfo>?> = _shopList
}