package org.sunrin.sunrintemplate.main.home

import androidx.recyclerview.widget.RecyclerView
import org.sunrin.sunrintemplate.data.structure.Friend
import org.sunrin.sunrintemplate.databinding.ItemFriendBinding

class FriendViewHolder(private val binding: ItemFriendBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: Friend) {
        binding.ivProfileImg.setImageResource(friendData.profileImg)
        binding.tvNickname.setText(friendData.nickname)
        binding.tvDescription.setText(friendData.description)
    }
}