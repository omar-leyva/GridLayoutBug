package com.example.gridlayoutbug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gridlayoutbug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Listener {

    private lateinit var adapter1: Adapter1

    private lateinit var adapter2: Adapter2

    private lateinit var concatAdapter: ConcatAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter1 = Adapter1()
        adapter1.listener = this
        adapter2 = Adapter2()
        concatAdapter = ConcatAdapter(
            ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
            adapter1,
            adapter2,
        )

        binding.rv.adapter = concatAdapter
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (concatAdapter.getItemViewType(position)) {
                    R.layout.layout_item1 -> 2
                    R.layout.layout_item2 -> 1
                    else -> 1
                }
            }
        }

        binding.rv.layoutManager = gridLayoutManager

    }

    override fun onResume() {
        super.onResume()

        adapter1.submitList(
            listOf(
                Item1("1")
            )
        )
        adapter2.submitList(
            listOf(
                Item2("1"),
                Item2("2"),
                Item2("3"),
                Item2("4"),
                Item2("5"),
                Item2("6"),
                Item2("7"),
            )
        )
    }

    override fun onClick() {
        adapter1.submitList(
            listOf(
                Item1("2")
            )
        )
    }

}