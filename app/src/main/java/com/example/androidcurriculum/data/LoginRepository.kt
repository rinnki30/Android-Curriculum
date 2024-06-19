package com.example.androidcurriculum.data

import com.example.androidcurriculum.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
//这个类用来请求远程数据源的验证和用户信息，并维护登录状态和用户凭证信息的内存缓存
class LoginRepository(val dataSource: LoginDataSource) {

    //
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun login(username: String, password: String): Result<LoggedInUser>? {
        dataSource.login(username, password)
        return dataSource.login(username, password)
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

//    fun login(username: String, password: String): Result<LoggedInUser> {
//        // handle login
//        val db = dbHelper.readableDatabase
//        val cursor: Cursor = db.query(
//            "Login",
//            arrayOf("id", "username", "password"),
//            "username = ? and password = ?",
//            arrayOf(username, password),
//            null,
//            null,
//            null
//        )
//        val result = dataSource.login(username, password)
//        if (result is Result.Success) {
//            setLoggedInUser(result.data)
//        }
//        cursor.close()
//        db.close()
//        return result
//    }


    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

}
//    //添加登录
//    fun addLogin(username: String, password: String): Long {
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

//    //获取所有登录
//    @SuppressLint("Range")
//    fun getAllContacts(): MutableList<LoggedInUser> {
//        val db = dbHelper.readableDatabase
//        val loggedInUser = mutableListOf<LoggedInUser>()
//
//        val cursor: Cursor = db.query(
//            "Login",
//            arrayOf("id", "username", "password"),
//            null,
//            null,
//            null,
//            null,
//            null
//        )
//        while (cursor.moveToNext()) {
//            val id = cursor.getString(cursor.getColumnIndex("id"))
//            val name = cursor.getString(cursor.getColumnIndex("username"))
//            val phone = cursor.getString(cursor.getColumnIndex("password"))
//            loggedInUser.add(LoggedInUser(id, name, phone))
//        }
//        cursor.close()
//        db.close()
//
//        return loggedInUser
