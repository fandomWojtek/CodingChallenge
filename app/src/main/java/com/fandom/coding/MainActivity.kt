package com.fandom.coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this, FigureViewModelFactory())[FiguresViewModel::class.java]
        val recycler = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = FigureAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        viewModel.figuresStream.observe(this) {
            adapter.listOfFigures = it
            adapter.notifyDataSetChanged()
        }
        viewModel.colorStream.observe(this) {
            adapter.listOfColors = it
            adapter.notifyDataSetChanged()
        }

        viewModel.load()
    }
}