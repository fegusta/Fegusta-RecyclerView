package com.fegusta.fegustarecyclerview.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_JOGO)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATABASE_NAME = "jogo.db"
        private const val DATABASE_VERSION = 1

        private const val  CREATE_TABLE_JOGO = "CREATE TABLE ${DatabaseDefinitions.Jogo.TABLE_NAME} (" +
                "${DatabaseDefinitions.Jogo.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DatabaseDefinitions.Jogo.Columns.TITULO} TEXT, " +
                "${DatabaseDefinitions.Jogo.Columns.PRODUTORA} TEXT, " +
                "${DatabaseDefinitions.Jogo.Columns.NOTA} REAL, " +
                "${DatabaseDefinitions.Jogo.Columns.CONSOLE} TEXT, " +
                "${DatabaseDefinitions.Jogo.Columns.ZERADO} INTEGER);"
    }
}