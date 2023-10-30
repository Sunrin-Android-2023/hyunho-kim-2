package org.sunrin.sunrintemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sunrin.sunrintemplate.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private var mBinding : ActivitySignInBinding ?= null
    private val binding : ActivitySignInBinding get() = requireNotNull(mBinding)
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