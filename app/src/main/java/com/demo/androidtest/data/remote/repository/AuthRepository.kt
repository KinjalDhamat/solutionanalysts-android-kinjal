package com.demo.androidtest.data.remote.repository

import androidx.lifecycle.MutableLiveData
import com.demo.androidtest.data.remote.ApiInterface
import com.demo.androidtest.data.remote.AppDataSource
import com.demo.androidtest.data.remote.result.BaseError
import com.demo.androidtest.data.remote.result.DataLoader
import com.demo.androidtest.data.remote.result.Resource
import com.demo.androidtest.ui.login.model.ReqLoginModel
import com.demo.androidtest.ui.login.model.ResLoginModel
import com.demo.androidtest.utils.PreferenceManager


class AuthRepository constructor(
    private var apiInterface: ApiInterface,
    private var preferenceManager: PreferenceManager
) : AppDataSource() {
    suspend fun login(
        loginLiveData: MutableLiveData<Resource<ResLoginModel>>,
        modelReq: ReqLoginModel
    ) {
        loginLiveData.postValue(Resource.Loading(DataLoader.LOADING_ALL))
        val result = apiCall(call = { apiInterface.loginAsync(modelReq).await() })
        if (result is ResLoginModel) {

            loginLiveData.postValue(Resource.Success(result))
        } else if (result is BaseError) {
            loginLiveData.postValue(Resource.Error(result))
        }
    }
}
