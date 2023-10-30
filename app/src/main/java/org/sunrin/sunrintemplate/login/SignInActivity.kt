package org.sunrin.sunrintemplate.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.popup
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.pref
import org.sunrin.sunrintemplate.databinding.ActivitySignInBinding
import org.sunrin.sunrintemplate.main.MainActivity

class SignInActivity : AppCompatActivity() {
    private var mBinding : ActivitySignInBinding ?= null
    private val binding : ActivitySignInBinding get() = requireNotNull(mBinding)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private lateinit var userId: String
    private lateinit var userPw: String
    private val isRemembered: Boolean = pref.getBoolean("isRemembered", false)

    private fun setUi(userId: String, userPw: String) {
        with(binding) {
            if(isRemembered) {
                etId.setText(userId)
                etPw.setText(userPw)
                cbRememberMe.toggle()
            }
            else if(userId != "")
                etId.setText(userId)
        }
    }

    private fun signIn(intentTo: Intent, userId: String, userPw: String) {
        with(binding) {
            val id: String = etId.text.toString()
            val pw: String = etPw.text.toString()
            var errorMsg: String = ""

            btnSignIn.setOnClickListener() {
                if(id != "" && id == userId) {
                    if(pw != "" && pw == userPw) {
                        if(cbRememberMe.isChecked)
                            pref.setBoolean("isRemembered", true)
                        else
                            pref.setBoolean("isRemembered", false)

                        popup.toast("sign in success")
                        startActivity(intentTo)
                    }
                    else {
                        errorMsg = "password does not match"
                        popup.snackbar(binding.root, errorMsg)
                        etPw.error = errorMsg
                    }
                }
                else {
                    errorMsg = "id does not match"
                    popup.snackbar(binding.root, errorMsg)
                    etId.error = errorMsg
                }
            }
        }
    }
    private fun signUp(intentTo: Intent) {
        binding.tvSignUp.setOnClickListener() {
            startActivity(intentTo)
        }
    }

    override fun onStart() {
        super.onStart()

        val intentMain : Intent = Intent(this@SignInActivity, MainActivity::class.java)
        val intentSignUp : Intent = Intent(this@SignInActivity, SignUpActivity::class.java)

        userId = intentSignUp.getStringExtra("userId") ?: pref.getString("userId", "").toString()
        userPw = pref.getString("userPw", "").toString()

        setUi(userId, userPw)

        signIn(intentMain, userId, userPw)
        signUp(intentSignUp)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}