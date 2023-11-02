package org.sunrin.sunrintemplate.main.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.pref
import org.sunrin.sunrintemplate.data.structure.User
import org.sunrin.sunrintemplate.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    private var mBinding : FragmentAccountBinding ?= null
    private val binding : FragmentAccountBinding get() = requireNotNull(mBinding)
    private lateinit var user : User
    private lateinit var userFollow : User.follow
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setUser() {
        user.id = pref.getString("userId", "") ?: ""
        user.profileImg = pref.getInt("userProfile", 0)
        user.nickname = pref.getString("userNickname", "") ?: ""
        user.description = pref.getString("userDes", "") ?: ""

        userFollow.follower = pref.getInt("userFollower", 0)
        userFollow.following = pref.getInt("userFollowing", 0)
    }

    private fun setUi(id: String, profileImg: Int, nickname: String, description: String, userFollower: Int, userFollowing: Int) {
        with(binding) {
            tvId.setText(id)
            ivProfileImg.setImageResource(profileImg)
            tvNickname.setText(nickname)
            tvDescription.setText(description)

            tvFollower.setText(userFollower)
            tvFollowing.setText(userFollowing)
        }
    }

    private fun menuOpen() {
        binding.ivMenu.setOnClickListener() {
        }
    }

    private fun intentTo(intentTo: Intent, btn: Button) {
        btn.setOnClickListener() {
            startActivity(intentTo)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUser()
        setUi(user.id, user.profileImg, user.nickname, user.description, userFollow.follower, userFollow.following)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}