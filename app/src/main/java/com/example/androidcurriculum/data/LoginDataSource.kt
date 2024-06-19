package com.example.androidcurriculum.data

import android.database.Cursor
import com.example.androidcurriculum.Database.MyDatabaseHelper
import com.example.androidcurriculum.MyApplication
import com.example.androidcurriculum.data.model.LoggedInUser

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
//这个类是用来处理登录验证的，包括登录凭证和获取用户信息
class LoginDataSource {
    private val dbHelper = MyDatabaseHelper(MyApplication.context, "Login.db", 1)
//    fun login(username: String, password: String): Result<LoggedInUser> {
//        try {
//            // TODO: handle loggedInUser authentication
//            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username, password)
//            return Result.Success(fakeUser)
//        } catch (e: Throwable) {
//            return Result.Error(IOException("Error logging in", e))
//        }
//    }

    fun login(username: String, password: String): Result<LoggedInUser>? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "Login",
            arrayOf("id", "username", "password"),
            "username = ? and password = ?",
            arrayOf(username, password),
            null,
            null,
            null
        )
        with(cursor) {
            if (moveToFirst()) {
                val id = getString(getColumnIndexOrThrow("id"))
                val username = getString(getColumnIndexOrThrow("username"))
                val password = getString(getColumnIndexOrThrow("password"))
                return Result.Success(LoggedInUser(id, username, password))
            }
        }
        cursor.close()
        db.close()
        return null
    }

    fun logout() {
        // TODO: revoke authentication
    }
}