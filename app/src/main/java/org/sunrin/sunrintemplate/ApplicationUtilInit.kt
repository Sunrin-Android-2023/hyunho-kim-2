package org.sunrin.sunrintemplate

import android.app.Application
import org.sunrin.sunrintemplate.util.PopUpUtil
import org.sunrin.sunrintemplate.util.PreferenceUtil

class ApplicationUtilInit : Application() {
    companion object {
        lateinit var pref : PreferenceUtil
        lateinit var popup : PopUpUtil
    }

    override fun onCreate() {
        super.onCreate()

        pref = PreferenceUtil(applicationContext)
        popup = PopUpUtil(applicationContext)
    }
}