package org.sunrin.sunrintemplate.main.home

import androidx.recyclerview.widget.RecyclerView
import org.sunrin.sunrintemplate.ApplicationUtilInit.Companion.popup
import org.sunrin.sunrintemplate.data.structure.Friend
import org.sunrin.sunrintemplate.databinding.ItemMyBinding

class MyViewHolder(private val binding: ItemMyBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(MyData: Friend) {
        binding.ivProfileImg.setImageResource(MyData.profileImg)
        binding.tvNickname.setText(MyData.nickname)
        binding.btnProfileEdit.setOnClickListener() {
            popup.toast("아직 구현되지 않은 기능입니다")
        }
    }
}