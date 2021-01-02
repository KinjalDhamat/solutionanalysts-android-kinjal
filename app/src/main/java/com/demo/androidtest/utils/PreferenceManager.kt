package com.demo.androidtest.utils

import android.content.SharedPreferences

class PreferenceManager constructor(private var sharedPreferences: SharedPreferences) {


    companion object {
        const val KEY_AUTH_TOKEN = "pre.accessToken"
    }

    fun saveString(key: String, accessToken: String?) {
        sharedPreferences.edit().putString(key, accessToken).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }


}
