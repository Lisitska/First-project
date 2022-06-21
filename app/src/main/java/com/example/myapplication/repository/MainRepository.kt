package com.example.myapplication.repository

import com.example.myapplication.datasource.UniversityDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class MainRepository(universityDataSource: UniversityDataSource = UniversityDataSource()) {
    val universityList = universityDataSource.universityList.flowOn(Dispatchers.IO)
}