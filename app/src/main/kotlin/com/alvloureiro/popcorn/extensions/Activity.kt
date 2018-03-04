package com.alvloureiro.popcorn.extensions

import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import com.alvloureiro.popcorn.PopcornApplication
import com.alvloureiro.popcorn.R


val AppCompatActivity.app: PopcornApplication get() = application as PopcornApplication

fun AppCompatActivity.hideSoftKeyboard() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

fun ProgressBar.showIn(context: Context?) {
    context.let({
        startAnimation(AnimationUtils.loadAnimation(it, R.anim.fade_in))
        visibility = View.VISIBLE
    })
}

fun ProgressBar.showOut(context: Context?) {
    context.let({
        startAnimation(AnimationUtils.loadAnimation(it, R.anim.fade_out))
        visibility = View.GONE
    })
}

fun String.toUri(): Uri {
    return Uri.parse(this)
}
