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
import com.fegusta.fegustarecyclerview.constants.Constants
import com.fegusta.fegustarecyclerview.datasource.DataSource
import com.fegusta.fegustarecyclerview.repository.JogoRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        insertToolbar()

        var buttomCadastrarJogo =findViewById<FloatingActionButton>(R.id.butotonCadastrarJogo)
        buttomCadastrarJogo.setOnClickListener(this)
    }

    override fun onResume() {
        iniciarRecyclerView()
        super.onResume()
    }

    private fun insertToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "Meu App Jogos"
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.butotonCadastrarJogo){
            val intent = Intent(this, CadastroJogoActivity::class.java)
            intent.putExtra("operacao", Constants.OPERACAO_NOVO_CADASTRO)
            startActivity(intent)
        }
    }

    private fun iniciarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJogos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repo = JogoRepository(this)
        recyclerView.adapter = JogosAdapter(repo.getJogos())
    }

}