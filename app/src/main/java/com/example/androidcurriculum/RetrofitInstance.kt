package com.example.androidcurriculum

import com.example.androidcurriculum.Service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http:/192.168.31.246:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}