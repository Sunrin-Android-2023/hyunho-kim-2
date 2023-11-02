package org.sunrin.sunrintemplate.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sunrin.sunrintemplate.R
import org.sunrin.sunrintemplate.data.structure.Friend
import org.sunrin.sunrintemplate.databinding.ItemMyBinding

class MyAdapter(context: Context): RecyclerView.Adapter<MyViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var myData: Friend = Friend(R.drawable.ic_sample, "", "")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemMyBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(myData)
    }

    override fun getItemCount(): Int = 1

    fun setMyData(my: Friend) {
        this.myData = my
        notifyDataSetChanged()
    }
}