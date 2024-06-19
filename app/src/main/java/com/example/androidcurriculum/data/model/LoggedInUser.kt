package com.example.androidcurriculum.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
//这个类用来存储从LoginRepository中获取的已登录用户的信息
data class LoggedInUser(
    val id: String,
    val username: String,
    val password: String,
)