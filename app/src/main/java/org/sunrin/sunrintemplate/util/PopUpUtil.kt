package org.sunrin.sunrintemplate.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class PopUpUtil(context: Context, v: View) {
    private val utilContext : Context = context
    private val utilView : View = v

    fun toast(s: String) {
        Toast.makeText(
            utilContext, s, Toast.LENGTH_SHORT
        ).show()
    }

    fun snackbar(s: String) {
        Snackbar.make(
            utilView, s, Snackbar.LENGTH_SHORT
        ).show()
    }
}