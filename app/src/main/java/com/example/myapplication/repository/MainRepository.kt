package com.example.myapplication.repository

import com.example.myapplication.datasource.ShopDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class MainRepository(shopDataSource: ShopDataSource = ShopDataSource()) {
    val shopList = shopDataSource.shopList.flowOn(Dispatchers.IO)
}