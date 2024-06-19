package com.example.androidcurriculum.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcurriculum.data.RegisterDataSource
import com.example.androidcurriculum.data.RegisterRepository

class RegisterViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(
                registerRepository = RegisterRepository(
                    dataSource = RegisterDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}