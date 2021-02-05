package com.example.gridlayoutbug

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gridlayoutbug.databinding.LayoutItem1Binding
import com.example.gridlayoutbug.databinding.LayoutItem2Binding
import kotlin.random.Random


class Item1ViewHolder(private val binding: LayoutItem1Binding) :
    ItemViewHolder(binding.root) {

    override fun bind(item: Item, listener: Listener?) {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        binding.txtItem1.setBackgroundColor(color)
        binding.txtItem1.text = "${item.id} ${item.type}"
        binding.txtItem1.setOnClickListener {
            listener?.onClick()
        }
    }

}

class Item2ViewHolder(private val binding: LayoutItem2Binding) :
    ItemViewHolder(binding.root) {

    override fun bind(item: Item, listener: Listener?) {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        binding.txtItem2.setBackgroundColor(color)
        binding.txtItem2.text = "${item.id} ${item.type}"
        binding.txtItem2.setOnClickListener {
            listener?.onClick()
        }
    }
}

abstract class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Item, listener: Listener?)
}
