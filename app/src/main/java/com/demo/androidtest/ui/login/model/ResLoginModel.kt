package com.demo.androidtest.ui.login.model

import androidx.annotation.Keep
import com.demo.androidtest.data.remote.result.BaseResult

@Keep
class ResLoginModel(
    val user: User? = null
) : BaseResult()

@Keep
data class User(
    val userName: String? = null,
    val userId: String? = null
)