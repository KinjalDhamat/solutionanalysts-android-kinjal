package com.demo.androidtest.injections

import android.util.Log
import com.demo.androidtest.utils.ApiConstant.HEADER_NAME
import com.demo.androidtest.utils.PreferenceManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import java.util.concurrent.TimeUnit


val networkModule = module {

    // Dependency: ApiService
//    single {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(get())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        retrofit.create(ApiInterface::class.java)
//    }

    // Dependency: HttpLoggingInterceptor
    single<Interceptor>(name = "INTERCEPTOR_LOGGING") {
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("OkHttp", message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single(name = "INTERCEPTOR_HEADER") {
        Interceptor { chain ->
            val prefManger: PreferenceManager = get()
//            val token = if (prefManger.getAccessToken() == null) "" else prefManger.getAccessToken()
            chain.proceed(
                chain.request().newBuilder().addHeader(
                    HEADER_NAME, ""
                ).build()
            )
        }
    }

    // Dependency: OkHttpClient
    single {
        OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .addInterceptor(get<Interceptor>("INTERCEPTOR_LOGGING"))
            .addInterceptor(get<Interceptor>("INTERCEPTOR_HEADER"))
            .build()
    }
}
