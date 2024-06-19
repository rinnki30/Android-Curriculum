package com.example.androidcurriculum.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcurriculum.R
import com.example.androidcurriculum.data.RegisterRepository
import com.example.androidcurriculum.data.Result

class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm

    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    //这是注册的函数
    fun register(username: String, password: String, confirmpassword: String) {
        //查询数据库验证注册
        val result = registerRepository.register(username, password)

        if (result is Result.Success<*>) {
            _registerResult.value = RegisterResult(success = RegisteredUserView(username))
        } else {
            _registerResult.value = RegisterResult(error = R.string.register_failed)
        }

    }

    //注册数据改变
    fun registerDataChanged(username: String, password: String, confirmpassword: String) {
        if (!isUserNameValid(username)) {
            _registerForm.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _registerForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else if (!isConfirmPasswordValid(password, confirmpassword)) {
            _registerForm.value =
                RegisterFormState(confirmpasswordError = R.string.invalid_confirmpassword)
        } else {
            _registerForm.value = RegisterFormState(isDataValid = true)
        }
    }

    //用户名的验证
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    //密码的验证
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    //确认密码的验证
    private fun isConfirmPasswordValid(password: String, confirmpassword: String): Boolean {
        return password == confirmpassword
    }
}