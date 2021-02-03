package com.example.gridlayoutbug

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gridlayoutbug.databinding.LayoutItem2Binding
import kotlin.random.Random

class Adapter2 : ListAdapter<Item2, Item2ViewHolder>(Item2Callback()) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_item2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item2ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Item2ViewHolder(LayoutItem2Binding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: Item2ViewHolder, position: Int) {
        holder.bind()
    }

}

class Item2ViewHolder(private val binding: LayoutItem2Binding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        binding.txtItem2.setBackgroundColor(color)
    }

}

data class Item2(val id: String)


class Item2Callback : DiffUtil.ItemCallback<Item2>() {
    override fun areItemsTheSame(oldItem: Item2, newItem: Item2): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item2, newItem: Item2): Boolean {
        return false
    }

}
