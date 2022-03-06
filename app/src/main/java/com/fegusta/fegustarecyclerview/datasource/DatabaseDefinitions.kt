package com.fegusta.fegustarecyclerview.datasource

class DatabaseDefinitions {

    object Jogo {
        const val TABLE_NAME = "tbl_jogo"

        object Columns {
            const val ID = "id"
            const val TITULO = "titulo"
            const val PRODUTORA = "produtora"
            const val NOTA = "nota"
            const val CONSOLE = "console"
            const val ZERADO = "zerado"
        }
    }
}