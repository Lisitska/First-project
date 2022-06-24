package com.example.myapplication.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*



class UniversityApi {
    suspend fun retrieveUniversities(): List<University> {
        val result :HttpResponse = retrieveUniversities0()
        val itemType = object : TypeToken<List<University>>() {}.type
        return Gson().fromJson<List<University>>(result.readText(), itemType)
    }

    suspend private fun retrieveUniversities0(): HttpResponse {
//        val response: HttpResponse = HttpClient().request("http://universities.hipolabs.com/search?country=Ukraine") {
//            method = HttpMethod.Get
//        }
//        val api = UniversityApi()
//        val response = api.retrieveUniversities()
//        Log.i("nikita", response.readText())

        val client = HttpClient()
        val response: HttpResponse = client.get(urlString = "http://universities.hipolabs.com/search") {
            url {
                parameters.append("country", "Ukraine")
            }
        }

        return response
    }

}