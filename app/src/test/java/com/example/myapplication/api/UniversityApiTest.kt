package com.example.myapplication.api

import kotlinx.coroutines.runBlocking
import org.junit.Test
class UniversityApiTest {

    @Test
    fun retrieveUniversities() = runBlocking {
        val api = UniversityApi()
        api.retrieveUniversities()
    }
}