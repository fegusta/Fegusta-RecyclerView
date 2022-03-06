package com.fegusta.fegustarecyclerview.datasource

import com.fegusta.fegustarecyclerview.model.Jogo
import java.util.*

class DataSource {

    companion object {

        fun getJogos() : ArrayList<Jogo> {
            var jogos = ArrayList<Jogo>()

            jogos.add(Jogo(100,"Residente Evil","",5.0f,"PS4"))

            return jogos
        }
    }
}