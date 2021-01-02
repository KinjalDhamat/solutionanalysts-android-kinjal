package com.demo.androidtest.utils

import com.demo.androidtest.R
import java.util.regex.Pattern

//*
// This function use to validate username
// */
fun isUserNameValid(userName: String?): Int {

    if (userName == null || userName.trim().isEmpty()) {
        return R.string.error_empty_username
    } else if (userName.length < 2) {
        return R.string.error_valid_username
    }
    return 0
}

//*
// This function use to validate password
// */
fun isPasswordValid(password: String?): Int {
    val expression = "^(?=.*[0-9])(?=.*[a-z]).{8,}"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)

    if (password == null || password.trim().isEmpty()) {
        return R.string.error_empty_password
    } else if (!pattern.matcher(password.trim()).matches()) {
        return R.string.error_valid_password
    }
    return 0
}
