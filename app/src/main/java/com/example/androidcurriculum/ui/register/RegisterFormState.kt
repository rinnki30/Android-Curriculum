package com.example.androidcurriculum.ui.register

data class RegisterFormState(

    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val confirmpasswordError: Int? = null,
    val isDataValid: Boolean = false
)