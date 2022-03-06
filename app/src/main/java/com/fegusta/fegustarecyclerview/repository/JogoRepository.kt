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

    fun getJogos() : ArrayList<Jogo>{
        val db = dbHelper.readableDatabase

        val projection = arrayOf(DatabaseDefinitions.Jogo.Columns.ID,
            DatabaseDefinitions.Jogo.Columns.TITULO,
            DatabaseDefinitions.Jogo.Columns.CONSOLE,
            DatabaseDefinitions.Jogo.Columns.NOTA)

        val orderBy ="${DatabaseDefinitions.Jogo.Columns.TITULO} ASC"

        val cursor = db.query(DatabaseDefinitions.Jogo.TABLE_NAME, projection,
            null,null,null,null,orderBy)

        var jogos = ArrayList<Jogo>()

        if (cursor != null){
            while (cursor.moveToNext()){
                var jogo = Jogo(
                    id = cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.ID)),
                    titulo = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.TITULO)),
                    console = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.CONSOLE)),
                    notaJogo = cursor.getFloat(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.NOTA))
                )
                jogos.add(jogo)
            }
        }
        return jogos
    }

    fun getJogo(id: Int): Jogo{
        val db = dbHelper.readableDatabase

        val projection = arrayOf(DatabaseDefinitions.Jogo.Columns.ID,
            DatabaseDefinitions.Jogo.Columns.TITULO,
            DatabaseDefinitions.Jogo.Columns.PRODUTORA,
            DatabaseDefinitions.Jogo.Columns.NOTA,
            DatabaseDefinitions.Jogo.Columns.CONSOLE,
            DatabaseDefinitions.Jogo.Columns.ZERADO)

        val selection = "${DatabaseDefinitions.Jogo.Columns.ID} = ?"

        val selectionArgs = arrayOf(id.toString())

        val cursor = db.query(DatabaseDefinitions.Jogo.TABLE_NAME, projection,
            selection,selectionArgs,null,null,null)

        var jogo = Jogo()

        if (cursor != null){
            cursor.moveToNext()
            jogo.id = cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.ID))
            jogo.titulo = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.TITULO))
            jogo.produtora = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.CONSOLE))
            jogo.notaJogo = cursor.getFloat(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.NOTA))
            jogo.console = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.PRODUTORA))
            jogo.zerado = cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Jogo.Columns.ZERADO)) == 1
        }
        return jogo

    }
}