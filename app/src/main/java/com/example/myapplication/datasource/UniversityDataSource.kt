package com.example.myapplication.datasource

import android.os.SystemClock
import com.example.myapplication.api.University
import com.example.myapplication.api.UniversityApi
import kotlinx.coroutines.flow.flow

class UniversityDataSource(private val mainApi: UniversityApi = UniversityApi()) {
    val universityList = flow {
        while (true) {
            try {
                val universities = mainApi.retrieveUniversities()
                emit(universities)
            } catch (e: Exception) {
                emit(null)
            }
            SystemClock.sleep(2000)
        }

    }
}