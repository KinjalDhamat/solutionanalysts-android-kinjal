package com.demo.androidtest.data.remote.result

import androidx.annotation.Keep

@Keep
open class BaseResult {
    var message: String? = null
    var code: String? = null
    var errorCode: String? = null
    var errorMessage: String? = null
}
