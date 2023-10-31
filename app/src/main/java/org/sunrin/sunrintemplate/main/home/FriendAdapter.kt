package org.sunrin.sunrintemplate.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sunrin.sunrintemplate.data.Friend
import org.sunrin.sunrintemplate.databinding.ItemFriendBinding

class FriendAdapter(context: Context): RecyclerView.Adapter<FriendViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var friendList: List<Friend> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(ItemFriendBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(friendList[position])
    }

    override fun getItemCount(): Int = friendList.size

    fun setFriendList(list: List<Friend>) {
        this.friendList = list.toList()
        notifyDataSetChanged()
    }
}