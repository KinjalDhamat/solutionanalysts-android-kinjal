package com.demo.androidtest.utils

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.demo.androidtest.App
import com.demo.androidtest.R
import com.google.android.material.snackbar.Snackbar
import java.util.*

/* Common method use for validate filed and set error */
fun setEditTextError(
    isAllFiledValid: Boolean = false,
    result: Int,
    field: MutableLiveData<String?>
): Boolean {
    return if (result != 0) {
        field.postValue(App.instance?.getString(result))
        false // isAllFiledValid && false == false
    } else {
        field.postValue("")
        isAllFiledValid // isAllFiledValid && true == isAllFieldValid
    }
}

/* Show snack bar message */
fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
        .setBackgroundTint(ContextCompat.getColor(this.context, android.R.color.white))
        .setTextColor(ContextCompat.getColor(this.context, R.color.colorPrimary))
        .show()
}

fun getIMSINumber(): String {
    return UUID.randomUUID().toString()
}

fun getIMEINumber(): String {
    return UUID.randomUUID().toString()
}