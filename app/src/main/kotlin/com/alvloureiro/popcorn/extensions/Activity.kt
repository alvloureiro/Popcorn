package com.alvloureiro.popcorn.extensions

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.alvloureiro.popcorn.PopcornApplication


val AppCompatActivity.app: PopcornApplication get() = application as PopcornApplication

inline fun AppCompatActivity.hideSoftKeyboard() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}
