package com.fegusta.fegustarecyclerview.repository

import android.content.ContentValues
import android.content.Context
import com.fegusta.fegustarecyclerview.datasource.DatabaseDefinitions
import com.fegusta.fegustarecyclerview.datasource.DatabaseHelper
import com.fegusta.fegustarecyclerview.model.Jogo

class JogoRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun save(jogo: Jogo) : Int {
        val db = dbHelper.writableDatabase

        val valores = ContentValues()
        valores.put(DatabaseDefinitions.Jogo.Columns.TITULO, jogo.titulo)
        valores.put(DatabaseDefinitions.Jogo.Columns.PRODUTORA, jogo.produtora)
        valores.put(DatabaseDefinitions.Jogo.Columns.NOTA, jogo.notaJogo)
        valores.put(DatabaseDefinitions.Jogo.Columns.CONSOLE, jogo.console)
        valores.put(DatabaseDefinitions.Jogo.Columns.ZERADO, jogo.zerado)

        val id = db.insert(DatabaseDefinitions.Jogo.TABLE_NAME, null,valores)
        return id.toInt()
    }

    fun update(jogo: Jogo) {

    }

    fun delete(id: Int){

    }

    fun getJogos(){

    }

    fun getJogo(id: Int){

    }
}