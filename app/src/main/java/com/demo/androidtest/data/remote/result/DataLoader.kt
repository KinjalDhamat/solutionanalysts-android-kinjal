package com.demo.androidtest.data.remote.result

import androidx.annotation.Keep

@Keep
enum class DataLoader {
    LOADING_ALL,
    LOADING_MORE,
    LOADING_CLOSE
}
