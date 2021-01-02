package com.demo.androidtest.data.local

import android.util.Log
import com.demo.androidtest.data.local.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Concrete implementation of a data source as a db.
 */
class AuthLocalDataSource internal constructor(
    private val authDao: AuthDao,
) {

    suspend fun saveUser(user: User) = withContext(Dispatchers.IO) {
        authDao.insertUser(user)
    }

}
