package com.example.myapplication.repository

import com.example.myapplication.datasource.UniversityDataSource
import com.example.myapplication.view.main.UniversityInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest

class MainRepository(universityDataSource: UniversityDataSource = UniversityDataSource()) {
    val universityList: Flow<List<UniversityInfo>?> = universityDataSource
        .universityList
        .mapLatest {
            when (it) {
                null -> {
                    null
                }
                else -> {
                    val universityInfoList = mutableListOf<UniversityInfo>()
                    for (university in it) {
                        universityInfoList.add(UniversityInfo(university.name, university.domains, university.web_pages))
                    }
                    universityInfoList
                }
            }
        }
        .flowOn(Dispatchers.IO)

    fun grabFilter(text: String){

    }

    fun executeFilter(list:List<UniversityInfo>, filter: String): List<UniversityInfo> {
        val filteredList = mutableListOf<UniversityInfo>()

        for (element in list) {
            if (element.name.contains(filter)){
                filteredList.add(element)
                }
        }

        // TODO: fill in filteredList

        return filteredList
    }
}