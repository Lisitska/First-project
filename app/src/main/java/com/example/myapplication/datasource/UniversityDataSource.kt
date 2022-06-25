package com.example.myapplication.datasource

import android.os.SystemClock
import com.example.myapplication.api.University
import com.example.myapplication.api.UniversityApi
import kotlinx.coroutines.flow.flow

class UniversityDataSource(private val mainApi: UniversityApi = UniversityApi()) {
    val universityList = flow {
        while (true) {
            val millis = System.currentTimeMillis()
            if (millis % 2L < 0) {
                emit(null)
            } else {
                val universities = mainApi.retrieveUniversities()
                emit(universities)
            }
            SystemClock.sleep(2000)
        }

    }
}