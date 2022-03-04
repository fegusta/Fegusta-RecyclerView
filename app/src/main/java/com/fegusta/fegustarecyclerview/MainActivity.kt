package com.fegusta.fegustarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fegusta.fegustarecyclerview.adapter.JogosAdapter
import com.fegusta.fegustarecyclerview.datasource.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarRecyclerView()
    }

    private fun iniciarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJogos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JogosAdapter(DataSource.getJogos())
    }
}