package com.example.gridlayoutbug

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gridlayoutbug.databinding.LayoutItem1Binding
import kotlin.random.Random

class Adapter1 : ListAdapter<Item1, Item1ViewHolder>(Item1Callback()) {

    var listener: Listener? = null

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_item1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item1ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Item1ViewHolder(LayoutItem1Binding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: Item1ViewHolder, position: Int) {
        holder.bind(listener)
    }

}

fun interface Listener {
    fun onClick()

}

class Item1ViewHolder(private val binding: LayoutItem1Binding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(listener: Listener?) {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        binding.txtItem1.setBackgroundColor(color)
        binding.txtItem1.setOnClickListener {
            listener?.onClick()
        }
    }

}

data class Item1(val id: String)


class Item1Callback : DiffUtil.ItemCallback<Item1>() {
    override fun areItemsTheSame(oldItem: Item1, newItem: Item1): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item1, newItem: Item1): Boolean {
        return false
    }

}
