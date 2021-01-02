package com.demo.androidtest.injections

import android.content.Context
import android.content.SharedPreferences
import com.demo.androidtest.utils.AppConstant.PREFERENCE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            PREFERENCE,
            Context.MODE_PRIVATE
        )
    }

}
