package com.example.myapplication.datasource

import android.os.SystemClock
import com.example.myapplication.api.University
import com.example.myapplication.api.UniversityApi
import com.example.myapplication.view.main.UniversityInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UniversityDataSource(private val mainApi: UniversityApi = UniversityApi()) {
    val universityList: Flow<List<University>?> = flow {
        while (true) {
            try {
                val universities = mainApi.retrieveUniversities()
                emit(universities)
            } catch (e: Exception) {
                emit(null)
            }
            SystemClock.sleep(64000)
        }

    }
}