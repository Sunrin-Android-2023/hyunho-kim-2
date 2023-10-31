package org.sunrin.sunrintemplate.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.popup
import org.sunrin.sunrintemplate.R
import org.sunrin.sunrintemplate.databinding.ActivityMainBinding
import org.sunrin.sunrintemplate.main.account.AccountFragment
import org.sunrin.sunrintemplate.main.feedback.FeedbackFragment
import org.sunrin.sunrintemplate.main.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding ?= null
    private val binding  : ActivityMainBinding get() = requireNotNull(mBinding)
    private var backBtnTime : Long = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }

    fun clickBnv() {
        binding.bnvMain.setOnItemSelectedListener() {
            when(it.itemId) {
                R.id.menu_feedback -> {
                    replaceFragment(FeedbackFragment())
                    true
                }
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.menu_person -> {
                    replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(supportFragmentManager.findFragmentById(R.id.fcv_main) == null)
            replaceFragment(HomeFragment())

        clickBnv()
    }

    override fun onBackPressed() {
        val curTime : Long = System.currentTimeMillis()
        val gapTime : Long = curTime - backBtnTime

        if(gapTime in 0..1500) {
            // 태스크를 백그라운드로 이동, 액티비티 종료 + 태스크 리스트에서 지우기, 앱 프로세스 종료
            moveTaskToBack(true)
            finishAndRemoveTask()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
        else{
            backBtnTime = curTime
            popup.toast("한번 더 누르면 종료됩니다")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}