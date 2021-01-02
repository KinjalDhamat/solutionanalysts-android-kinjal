package com.demo.androidtest.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.demo.androidtest.R
import com.demo.androidtest.databinding.ActivityLoginBinding
import com.demo.androidtest.ui.login.viewmodel.LoginViewModel
import com.demo.androidtest.utils.showSnackBar
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login) as ViewDataBinding?
        val mActivitySplashBinding = binding as ActivityLoginBinding
        mActivitySplashBinding.viewModel = viewModel
        mActivitySplashBinding.lifecycleOwner = this

        super.onCreate(savedInstanceState)
        initializeComponent(binding.root)
    }

    private fun initializeComponent(root: View) {
        viewModel.showSnackBar.observe(this, {
            root.showSnackBar(getString(it))
        })
    }
}