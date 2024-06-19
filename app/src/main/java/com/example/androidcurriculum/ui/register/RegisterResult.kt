package com.example.androidcurriculum.ui.register

//这是注册结果：成功（注册用户视图）或错误消息
data class RegisterResult(
    val success: RegisteredUserView? = null,
    val error: Int? = null
)