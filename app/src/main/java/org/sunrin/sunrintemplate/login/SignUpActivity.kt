package org.sunrin.sunrintemplate.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sunrin.sunrintemplate.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private var mBinding : ActivitySignUpBinding ?= null
    private val binding : ActivitySignUpBinding get() = requireNotNull(mBinding)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpBinding.inflate(layoutInflater)
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