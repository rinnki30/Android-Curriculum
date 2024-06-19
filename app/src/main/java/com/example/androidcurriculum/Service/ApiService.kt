package com.example.androidcurriculum.Service

import com.example.androidcurriculum.data.model.Article
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("app_data.json")
    fun getArticles(): Call<Article>

}