package com.example.myapplication.datasource

import android.os.SystemClock
import com.example.myapplication.view.main.UniversityInfo
import kotlinx.coroutines.flow.flow

class UniversityDataSource {
    val universityList = flow<List<UniversityInfo>?> {

        val university = mutableListOf(
            UniversityInfo("ALDI", "Tulpenweg 1, 15834, Rangsdorf", 4,"Distance - 3 km"),
            UniversityInfo("LIDL", "Tulpenweg 2, 15834, Rangsdorf", 4, "Distance 2 km"),
            UniversityInfo("EDEKA", "Tulpenweg 3, 15834, Rangsdorf", 5, "Distance 5 km"),
            UniversityInfo("NETTO", "Tulpenweg 4, 15834, Rangsdorf", 3, "Distance 1 km"),
            UniversityInfo("ALDI", "Tulpenweg 7, 15834, Rangsdorf", 4, "Distance 2 km"),
            UniversityInfo("LIDL", "Tulpenweg 8, 15834, Rangsdorf", 4, "Distance 3 km"),
            UniversityInfo("EDEKA", "Tulpenweg 9, 15834, Rangsdorf", 3,"Distance 7 km"),
            UniversityInfo("NETTO", "Tulpenweg 10, 15834, Rangsdorf", 3, "Distance 5 km")
        )
        while (true) {
            val millis = System.currentTimeMillis()
            if (millis % 2L == 0L) {
                emit(null)
            } else {
                emit(university)
            }
            SystemClock.sleep(2000)
        }

    }
}