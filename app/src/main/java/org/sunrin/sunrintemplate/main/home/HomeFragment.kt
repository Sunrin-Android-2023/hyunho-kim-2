package org.sunrin.sunrintemplate.main.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.ConcatAdapter
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.pref
import org.sunrin.sunrintemplate.R
import org.sunrin.sunrintemplate.data.structure.Friend
import org.sunrin.sunrintemplate.databinding.FragmentHomeBinding
import org.sunrin.sunrintemplate.main.MainActivity
import org.sunrin.sunrintemplate.main.account.AccountFragment

class HomeFragment : Fragment() {
    private var mBinding : FragmentHomeBinding ?= null
    private val binding : FragmentHomeBinding get() = requireNotNull(mBinding)
    private lateinit var userData : Friend
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val mockFriendList = listOf<Friend>(
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "hyunhomon",
            description = "Hi! My name is hyunhomon"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "compy",
            description = "I'm compy"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "seoJh",
            description = "HaHaHa"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "hoonih",
            description = "android studio~~ and my name is John Sina!!"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        ),
        Friend(
            profileImg = R.drawable.ic_sample,
            nickname = "test",
            description = "hahahahahahahahahahahaha"
        )
    )

    private fun intentTo(intentTo: Intent, btn: Button) {
        btn.setOnClickListener() {
            startActivity(intentTo)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userData = Friend(R.drawable.ic_sample, pref.getString("userNickname", "") ?: "", "")

        val myAdapter = MyAdapter(requireContext())
        val friendAdapter = FriendAdapter(requireContext())
        val homeAdapter = ConcatAdapter(myAdapter, friendAdapter)

        friendAdapter.setFriendList(mockFriendList)
        myAdapter.setMyData(userData)

        binding.rvFriend.adapter = homeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}