package com.demo.androidtest

import android.app.Application
import com.demo.androidtest.injections.appModule
import com.demo.androidtest.injections.dataBaseModule
import com.demo.androidtest.injections.networkModule
import com.demo.androidtest.injections.viewModelModule
import com.demo.testapp.injections.repositoryModule
import org.koin.android.ext.android.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        iniKoinModules()
    }

    override fun onTerminate() {
        super.onTerminate()
        if (instance != null) {
            instance = null
        }
    }

    companion object {
        var instance: App? = null
    }

    private fun iniKoinModules() {
        startKoin(
            this,
            listOf(viewModelModule, appModule, networkModule, repositoryModule, dataBaseModule)
        )
    }

}
