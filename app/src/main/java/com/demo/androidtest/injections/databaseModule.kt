package com.demo.androidtest.injections

import AuthLocalDataSource
import androidx.room.Room
import com.demo.androidtest.data.local.AppDatabase
import com.demo.androidtest.utils.AppConstant.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val dataBaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    single {
        val appDatabase: AppDatabase = get()
        appDatabase.authDao()
    }

    single {
        AuthLocalDataSource(get(), get())
    }
}
