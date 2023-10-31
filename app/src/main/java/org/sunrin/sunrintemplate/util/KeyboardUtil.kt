package org.sunrin.sunrintemplate.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class KeyboardUtil(context: Context) {
    fun setupHideKeyboardOnBackgroundClick(activity: Activity, backgroundView: View) {
        backgroundView.setOnClickListener {
            hideKeyboard(activity)
        }
    }

    fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = activity.currentFocus
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}