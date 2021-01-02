package com.demo.androidtest.data.remote

import com.demo.androidtest.ui.login.model.ReqLoginModel
import com.demo.androidtest.ui.login.model.ResLoginModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {

    @POST("login")
    fun loginAsync(@Body modelReq: ReqLoginModel): Deferred<Response<ResLoginModel>>

}
