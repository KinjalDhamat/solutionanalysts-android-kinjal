package com.demo.androidtest.ui.login.viewmodel

import android.app.Application
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.demo.androidtest.R
import com.demo.androidtest.base.SingleLiveEvent
import com.demo.androidtest.utils.*

class LoginViewModel(application: Application) : AndroidViewModel(application) {


    var userName: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    var password: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }

    var userNameError = MutableLiveData<String?>().apply { value = "" }
    var passwordError = MutableLiveData<String?>().apply { value = "" }

    val showSnackBar = SingleLiveEvent<Int>()

    @RequiresApi(Build.VERSION_CODES.M)
    fun onLoginClick(view: View) {
        if (isNetworkAvailable(getApplication())) {
            KeyboardUtils.hideKeyboard(view)
            validateFields()
        } else {
            showSnackBar.postValue(R.string.error_message_network)
        }
    }

    //validate login fields
    private fun validateFields(): Boolean {

        var isValidate = true

        val resultEmail = isUserNameValid(userName.value)
        isValidate = setEditTextError(isValidate, resultEmail, userNameError)

        val resultPassword = isPasswordValid(password.value)
        isValidate = setEditTextError(isValidate, resultPassword, passwordError)

        return isValidate
    }

}