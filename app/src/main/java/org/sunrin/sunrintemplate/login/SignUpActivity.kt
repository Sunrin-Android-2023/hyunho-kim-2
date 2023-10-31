package org.sunrin.sunrintemplate.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.popup
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.pref
import org.sunrin.sunrintemplate.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    private var mBinding : ActivitySignUpBinding ?= null
    private val binding : ActivitySignUpBinding get() = requireNotNull(mBinding)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun regex(case: String, s: String): Boolean {
        lateinit var pattern : Pattern

        when(case) {
            "id" -> pattern = Pattern.compile("^[a-zA-Z0-9]{6,10}\$") // 공백 불가, 영문자만 가능, 특수문자 금지, 6~10 글자 사이
            "pw" -> pattern = Pattern.compile("^\\S{8,12}\$") // 공백 불가, 영문자, 특수문자 가능, 8~12 글자 사이
            "nickname" -> pattern = Pattern.compile("^[a-zA-Z0-9]{1,10}\$") // 공백 불가, 영문자만 가능, 특수문자 금지, 1~10 글자 사이
            else -> pattern = Pattern.compile("") // 예외 상황 시 무조건
        }

        return s.matches(pattern.toRegex())
    }

    private fun setUserData(id: String, pw: String, nickname: String) {
        pref.setString("userId", id)
        pref.setString("userPw", pw)
        pref.setString("userNickname", nickname)
    }

    private fun notMatch(et: EditText, s: String) {
        popup.snackbar(binding.root, s)
        et.error = s
    }

    private fun signUp(intentTo: Intent) {
        with(binding) {
            btnSignUp.setOnClickListener() {
                val id: String = etId.text.toString()
                val pw: String = etPw.text.toString()
                val nickname: String = etNickname.text.toString()

                if(regex("id", id)) {
                    if(regex("nickname", nickname)) {
                        if(regex("pw", pw)) {
                            if(cbAgreeTo.isChecked) {
                                setUserData(id, pw, nickname)

                                popup.toast("sign up success")
                                intentTo.putExtra("userId", id)
                                intentTo.putExtra("isSignUp", true)
                                intentTo.flags = Intent.FLAG_ACTIVITY_NO_HISTORY

                                startActivity(intentTo)
                                finish()
                            }
                            else {
                                popup.snackbar(binding.root, "please agree with our privacy policy")
                            }
                        }
                        else {
                            notMatch(etPw, "password must be 8 ~ 12 characters")
                        }
                    }
                    else {
                        notMatch(etNickname, "nickname must be 1 ~ 10 characters")
                    }
                }
                else {
                    notMatch(etId, "id must be 6 ~ 10 characters")
                }
            }
        }
    }
    private fun signIn(intentTo: Intent) {
        binding.tvSignIn.setOnClickListener() {
            intentTo.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intentTo)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        val intentSignIn : Intent = Intent(this@SignUpActivity, SignInActivity::class.java)

        signUp(intentSignIn)
        signIn(intentSignIn)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}