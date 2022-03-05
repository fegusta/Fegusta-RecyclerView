package com.fegusta.fegustarecyclerview.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fegusta.fegustarecyclerview.R
import com.fegusta.fegustarecyclerview.adapter.JogosAdapter
import com.fegusta.fegustarecyclerview.datasource.DataSource
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarRecyclerView()

        var buttomCadastrarJogo =findViewById<FloatingActionButton>(R.id.butotonCadastrarJogo)
        buttomCadastrarJogo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.butotonCadastrarJogo){
            val intent = Intent(this, CadastroJogoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun iniciarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJogos)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = JogosAdapter(DataSource.getJogos())
    }

}