package org.sunrin.sunrintemplate.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.pref
import org.sunrin.sunrintemplate.R
import org.sunrin.sunrintemplate.data.structure.Friend
import org.sunrin.sunrintemplate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var mBinding : FragmentHomeBinding ?= null
    private val binding : FragmentHomeBinding get() = requireNotNull(mBinding)
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
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = MyAdapter(requireContext())
        val friendAdapter = FriendAdapter(requireContext())
        val homeAdapter = ConcatAdapter(myAdapter, friendAdapter)

        friendAdapter.setFriendList(mockFriendList)
        myAdapter.setMyData(Friend(R.drawable.ic_sample, pref.getString("userNickname", "") ?: "", ""))

        binding.rvFriend.adapter = homeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}