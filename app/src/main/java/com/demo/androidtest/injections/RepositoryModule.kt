package com.demo.androidtest.injections


import com.demo.androidtest.data.repository.AuthRepository
import org.koin.dsl.module.module

val repositoryModule = module {


    single {
        AuthRepository(
            get(),
            get(),
        )//it will take two argument ApiInterface and PreferenceManager
    }

}
