package com.fegusta.fegustarecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fegusta.fegustarecyclerview.R

class CadastroJogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_jogo)

        insertToolbar()
    }

    private fun insertToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "Novo Jogo"
    }
}