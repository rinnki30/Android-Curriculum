package com.example.androidcurriculum.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
//这个类用来存储一个带有其加载状态的值
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}