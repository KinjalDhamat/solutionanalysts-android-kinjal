package com.demo.androidtest.ui.login.viewmodel

import android.app.Application
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demo.androidtest.R
import com.demo.androidtest.base.SingleLiveEvent
import com.demo.androidtest.data.remote.repository.AuthRepository
import com.demo.androidtest.data.remote.result.Resource
import com.demo.androidtest.ui.login.model.ReqLoginModel
import com.demo.androidtest.ui.login.model.ResLoginModel
import com.demo.androidtest.utils.*
import kotlinx.coroutines.launch

class LoginViewModel(application: Application, private val authRepository: AuthRepository) :
    AndroidViewModel(application) {


    var userName: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    var password: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }

    var userNameError = MutableLiveData<String?>().apply { value = "" }
    var passwordError = MutableLiveData<String?>().apply { value = "" }

    val showSnackBar = SingleLiveEvent<Int>()
    val loginLiveData = SingleLiveEvent<Resource<ResLoginModel>>()

    @RequiresApi(Build.VERSION_CODES.M)
    fun onLoginClick(view: View) {
        if (isNetworkAvailable(getApplication())) {
            KeyboardUtils.hideKeyboard(view)
            if (validateFields()) {
                callLogin()
            }
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

    private fun callLogin() {

        viewModelScope.launch {
            authRepository.login(
                loginLiveData,
                ReqLoginModel(username = userName.value, password = password.value)
            )
        }

    }
}