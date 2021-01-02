package com.demo.androidtest.injections

import com.demo.androidtest.ui.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {


    viewModel {
        LoginViewModel(get())
    }
}
