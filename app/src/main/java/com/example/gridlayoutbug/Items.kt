package com.example.gridlayoutbug

import androidx.recyclerview.widget.DiffUtil


data class Item1(override val id: String, override val type: Int = R.layout.layout_item1) : Item()
data class Item2(override val id: String, override val type: Int = R.layout.layout_item2) : Item()

sealed class Item {
    abstract val id: String
    abstract val type: Int
}

class ItemCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id && oldItem.type == newItem.type
    }

}