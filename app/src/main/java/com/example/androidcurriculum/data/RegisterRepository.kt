package com.example.androidcurriculum.data

import com.example.androidcurriculum.Database.MyDatabaseHelper
import com.example.androidcurriculum.MyApplication
import com.example.androidcurriculum.data.model.LoggedInUser

class RegisterRepository(val dataSource: RegisterDataSource) {
    private val dbHelper = MyDatabaseHelper(MyApplication.context, "Login.db", 1)

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun register(username: String, password: String): Any {
        if (dataSource.checkUsernameExists(username)) {
            return Result.Error(Exception("Username already exists"))
        }
        dataSource.register(username, password)
        return dataSource.register(username, password)
    }
//    fun register(username: String, password: String): Long {
//        val db = dbHelper.writableDatabase
//        val values = ContentValues().apply {
//            put("username", username)
//            put("password", password)
//        }
//        return try {
//            val result = db.insert("Login", null, values)
//            result
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            -1
//        } finally {
//            db.close()
//        }
//    }


    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

}