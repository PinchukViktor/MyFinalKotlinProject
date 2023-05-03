package com.example.finalproject.data

import com.example.finalproject.data.remote.ApiFactory
import com.example.finalproject.data.remote.model.ApiModel

object CatRepository {
    private val api = ApiFactory.catApi

    suspend fun getFactsOfCats(): ApiModel? {

        val params = HashMap<String, String>()
        params.put("animal_type", "cat")
        params.put("amount", "1")

        val response = api.getFacts(params)

        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }
        return null

    }

}