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

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

}
