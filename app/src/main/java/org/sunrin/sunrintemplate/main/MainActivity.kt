package org.sunrin.sunrintemplate.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sunrin.sunrintemplate.databinding.ActivityMainBinding
import org.sunrin.sunrintemplate.util.PopUpUtil
import org.sunrin.sunrintemplate.util.PreferenceUtil

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding ?= null
    private val binding  : ActivityMainBinding get() = requireNotNull(mBinding)
    private val preferenceUtil : PreferenceUtil by lazy { PreferenceUtil(applicationContext) }
    private val popupUtil : PopUpUtil by lazy { PopUpUtil(applicationContext, binding.root) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}