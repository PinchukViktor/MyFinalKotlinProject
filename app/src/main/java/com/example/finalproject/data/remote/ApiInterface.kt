package com.example.finalproject.data.remote

import com.example.finalproject.data.remote.model.ApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface ApiInterface {
    @GET("/facts/random")
    suspend fun getFacts(@QueryMap params: Map<String, String>): Response<ApiModel>
}