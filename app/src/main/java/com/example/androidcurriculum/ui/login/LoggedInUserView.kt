package com.example.androidcurriculum.ui.login

/**
 * User details post authentication that is exposed to the UI
 */
//这是用户在验证后暴露给UI的详细信息
data class LoggedInUserView(
    val username: String
    //... other data fields that may be accessible to the UI
)