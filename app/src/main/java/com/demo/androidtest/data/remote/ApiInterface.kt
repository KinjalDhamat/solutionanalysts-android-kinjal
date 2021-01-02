package com.demo.androidtest.data.remote

import com.demo.androidtest.ui.login.model.ReqLogin
import com.demo.androidtest.ui.login.model.ResLogin
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {

    @POST("login")
    fun loginAsync(@Body modelReq: ReqLogin): Deferred<Response<ResLogin>>

}
