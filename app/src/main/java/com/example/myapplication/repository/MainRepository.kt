package com.example.myapplication.repository

import com.example.myapplication.api.University
import com.example.myapplication.datasource.UniversityDataSource
import com.example.myapplication.view.main.UniversityInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class MainRepository(universityDataSource: UniversityDataSource = UniversityDataSource()) {
    private var filterFlow = MutableSharedFlow<String>(replay = 1, onBufferOverflow  = BufferOverflow.DROP_OLDEST).apply {
        this.tryEmit("")
    }
    val universityList: Flow<List<UniversityInfo>?> = universityDataSource
        .universityList.combine(filterFlow) { list: List<University>?, filter: String ->
            when (list) {
                null -> {
                    null
                }
                else -> {
                    val universityInfoList = mutableListOf<UniversityInfo>()
                    for (university in list) {
                        universityInfoList.add(UniversityInfo(university.name, university.domains, university.web_pages))
                    }
                    executeFilter(universityInfoList, filter)
                }
            }

        }
        .flowOn(Dispatchers.IO)

    fun grabFilter(text: String){
        this.filterFlow.tryEmit(text)
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