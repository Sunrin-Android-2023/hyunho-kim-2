package org.sunrin.sunrintemplate.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class PopUpUtil(context: Context) {
    private val utilContext : Context = context

    fun toast(s: String) {
        Toast.makeText(
            utilContext, s, Toast.LENGTH_SHORT
        ).show()
    }

    fun snackbar(v: View, s: String) {
        Snackbar.make(
            v, s, Snackbar.LENGTH_SHORT
        ).show()
    }
}