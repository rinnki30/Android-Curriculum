package com.example.androidcurriculum.ui.login

/**
 * Authentication result : success (user details) or error message.
 */
//这是验证结果：成功（用户详细信息）或错误消息
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)