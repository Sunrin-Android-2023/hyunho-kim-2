package org.sunrin.sunrintemplate.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sunrin.sunrintemplate.databinding.ActivitySignInBinding
import org.sunrin.sunrintemplate.util.PopUpUtil
import org.sunrin.sunrintemplate.util.PreferenceUtil

class SignInActivity : AppCompatActivity() {
    private var mBinding : ActivitySignInBinding ?= null
    private val binding : ActivitySignInBinding get() = requireNotNull(mBinding)
    private val preferenceUtil : PreferenceUtil by lazy { PreferenceUtil(applicationContext) }
    private val popupUtil : PopUpUtil by lazy { PopUpUtil(applicationContext, binding.root) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignInBinding.inflate(layoutInflater)
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