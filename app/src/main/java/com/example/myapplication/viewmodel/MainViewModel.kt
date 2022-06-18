package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.view.main.ShopInfo

class MainViewModel : ViewModel() {

    private val _shopList =  MutableLiveData<List<ShopInfo>?>().apply {
        val shops = mutableListOf(
            ShopInfo("ALDI", "Tulpenweg 1, 15834, Rangsdorf", 4,"Distance - 3 km"),
            ShopInfo("LIDL", "Tulpenweg 2, 15834, Rangsdorf", 4, "Distance 2 km"),
            ShopInfo("EDEKA", "Tulpenweg 3, 15834, Rangsdorf", 5, "Distance 5 km"),
            ShopInfo("NETTO", "Tulpenweg 4, 15834, Rangsdorf", 3, "Distance 1 km"),
            ShopInfo("ALDI", "Tulpenweg 7, 15834, Rangsdorf", 4, "Distance 2 km"),
            ShopInfo("LIDL", "Tulpenweg 8, 15834, Rangsdorf", 4, "Distance 3 km"),
            ShopInfo("EDEKA", "Tulpenweg 9, 15834, Rangsdorf", 3,"Distance 7 km"),
            ShopInfo("NETTO", "Tulpenweg 10, 15834, Rangsdorf", 3, "Distance 5 km"))

        value = shops
    }

    val shopList: LiveData<List<ShopInfo>?> = _shopList
}