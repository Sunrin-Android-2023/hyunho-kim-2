package org.sunrin.sunrintemplate.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.keyboard
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

    private fun setUi(intentTo: Intent, userId: String, userPw: String) {
        with(binding) {
            if(intentTo.getBooleanExtra("isSignUp", false))
                etId.setText(userId)
            else if(isRemembered) {
                etId.setText(userId)
                etPw.setText(userPw)
                cbRememberMe.toggle()
            }
            else {
                etId.setText("")
                etPw.setText("")
            }
        }
    }

    private fun notMatch(et: EditText, s: String) {
        popup.snackbar(binding.root, s)
        et.error = s
    }

    private fun signIn(intentTo: Intent, userId: String, userPw: String) {
        with(binding) {
            btnSignIn.setOnClickListener() {
                val id: String = etId.text.toString()
                val pw: String = etPw.text.toString()

                if(id != "" && id == userId) {
                    if(pw != "" && pw == userPw) {
                        if(cbRememberMe.isChecked)
                            pref.setBoolean("isRemembered", true)
                        else
                            pref.setBoolean("isRemembered", false)

                        popup.toast("sign in success")

                        intentTo.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
                        startActivity(intentTo)
                        finish()
                    }
                    else {
                        notMatch(etPw, "password does not match")
                    }
                }
                else {
                    notMatch(etId, "id does not match")
                }
            }
        }
    }
    private fun signUp(intentTo: Intent) {
        binding.tvSignUp.setOnClickListener() {
            intentTo.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intentTo)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        val intentMain : Intent = Intent(this@SignInActivity, MainActivity::class.java)
        val intentSignUp : Intent = Intent(this@SignInActivity, SignUpActivity::class.java)

        userId = intentSignUp.getStringExtra("userId") ?: pref.getString("userId", "").toString()
        userPw = pref.getString("userPw", "").toString()

        setUi(intentSignUp, userId, userPw)

        keyboard.setupHideKeyboardOnBackgroundClick(this@SignInActivity, binding.root)

        signIn(intentMain, userId, userPw)
        signUp(intentSignUp)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}