package org.sunrin.sunrintemplate.util

import android.content.Context

class PreferenceUtil(context: Context) {
    private val prefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String? {
        return prefs.getString(key, defValue)
    }

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return prefs.getBoolean(key, defValue)
    }

    fun setBoolean(key: String, bool: Boolean) {
        prefs.edit().putBoolean(key, bool).apply()
    }
}