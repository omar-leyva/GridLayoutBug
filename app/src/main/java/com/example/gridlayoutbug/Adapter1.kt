package com.example.gridlayoutbug

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gridlayoutbug.databinding.LayoutItem1Binding
import com.example.gridlayoutbug.databinding.LayoutItem2Binding

class Adapter1 : ListAdapter<Item, ItemViewHolder>(ItemCallback()) {

    var listener: Listener? = null

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.layout_item1 -> Item1ViewHolder(LayoutItem1Binding.inflate(inflater, parent, false))
            R.layout.layout_item2 -> Item2ViewHolder(LayoutItem2Binding.inflate(inflater, parent, false))
            else -> throw RuntimeException("error")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}

fun interface Listener {
    fun onClick()

}
