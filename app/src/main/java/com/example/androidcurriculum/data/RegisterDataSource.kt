package com.example.androidcurriculum.data

import android.content.ContentValues
import com.example.androidcurriculum.Database.MyDatabaseHelper
import com.example.androidcurriculum.MyApplication
import com.example.androidcurriculum.data.model.RegisteredInUser

//这个类是用来处理注册验证的，包括注册凭证和获取用户信息
class RegisterDataSource {
    //        fun register(
//        username: String,
//        password: String,
//        confirmpassword: String
//    ): Result<RegisteredInUser> {
//        try {
//            // TODO: handle loggedInUser authentication
//            val fakeUser = RegisteredInUser(
//                java.util.UUID.randomUUID().toString(),
//                username,
//                password,
//                confirmpassword
//            )
//            return Result.Success(fakeUser)
//        } catch (e: Throwable) {
//            return Result.Error(IOException("Error register in", e))
//        }
//    }
    private val dbHelper = MyDatabaseHelper(MyApplication.context, "Login.db", 1)
    fun register(username: String, password: String): Result<RegisteredInUser> {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("username", username)
            put("password", password)
        }
        db.insert("Login", null, values)
        db.close()
        return Result.Success(RegisteredInUser(username, password))
    }

    fun checkUsernameExists(username: String): Boolean {
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            "Login",
            arrayOf("username"),
            "username = ?",
            arrayOf(username),
            null,
            null,
            null
        )
        val exists = cursor.moveToFirst()
        cursor.close()
        return exists
    }
}