package com.demo.androidtest.base

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


class AppBinding {

    companion object {

        @BindingAdapter("setInputMessage")
        @JvmStatic
        fun setInputMessage(view: TextInputLayout, errorMessage: String?) {
            errorMessage?.let {
                view.error = it
                view.isErrorEnabled = !errorMessage.isNullOrEmpty()
            }
        }

        @JvmStatic
        @BindingAdapter("app:onEditorAction")
        fun onEditorAction(editText: EditText, listener: TextView.OnEditorActionListener) {
            editText.setOnEditorActionListener(listener)
        }

    }


}