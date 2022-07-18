package com.example.myapplication.repository

import com.example.myapplication.datasource.UniversityDataSource
import com.example.myapplication.view.main.UniversityInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest

class MainRepository(universityDataSource: UniversityDataSource = UniversityDataSource()) {
    private var filter: String = ""

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
                    executeFilter(universityInfoList, filter)
                }
            }

        }
        .flowOn(Dispatchers.IO)

    fun grabFilter(text: String){
        this.filter = text
    }

    fun executeFilter(list:List<UniversityInfo>, filter: String): List<UniversityInfo> {
        val filteredList = mutableListOf<UniversityInfo>()

        val lowerCaseFilter = filter.toLowerCase()
        for (element in list) {
            val lowerCaseName = element.name.toLowerCase()
            if (lowerCaseName.contains(lowerCaseFilter) ||
                element.domains.any { it.contains(lowerCaseFilter) }){
                filteredList.add(element)
            }
        }
        return filteredList
    }

}