package com.demo.androidtest.data.repository

import AuthLocalDataSource
import androidx.lifecycle.MutableLiveData
import com.demo.androidtest.data.local.model.User
import com.demo.androidtest.data.remote.ApiInterface
import com.demo.androidtest.data.remote.BaseRemoteDataSource
import com.demo.androidtest.data.remote.result.BaseError
import com.demo.androidtest.data.remote.result.DataLoader
import com.demo.androidtest.data.remote.result.Resource
import com.demo.androidtest.ui.login.model.ReqLogin
import com.demo.androidtest.ui.login.model.ResLogin
import com.demo.androidtest.utils.ApiConstant


class AuthRepository constructor(
    private var apiInterface: ApiInterface,
    private var authLocalDataSource: AuthLocalDataSource
) : BaseRemoteDataSource() {

    suspend fun login(
        loginLiveData: MutableLiveData<Resource<ResLogin>>,
        modelReq: ReqLogin
    ) {
        loginLiveData.postValue(Resource.Loading(DataLoader.LOADING_ALL))
        val result = apiCall(call = { apiInterface.loginAsync(modelReq).await() })
        if (result is ResLogin) {
            saveUserLocally(result)
            loginLiveData.postValue(Resource.Success(result))
        } else if (result is BaseError) {
            loginLiveData.postValue(Resource.Error(result))
        }
    }

    private suspend fun saveUserLocally(result: ResLogin) {
        val user = User(
            userId = result.user?.userId ?: 0,
            userName = result.user?.userName ?: "",
            xAcc = result.headers?.get(ApiConstant.X_ACC_HEADER) ?: ""
        )
        authLocalDataSource.saveUser(user)

    }
}
