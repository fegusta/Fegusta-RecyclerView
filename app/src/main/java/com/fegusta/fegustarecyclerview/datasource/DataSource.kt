package com.fegusta.fegustarecyclerview.datasource

import com.fegusta.fegustarecyclerview.model.Jogo
import java.util.*

class DataSource {

    companion object {

        fun getJogos() : ArrayList<Jogo> {
            var jogos = ArrayList<Jogo>()

            jogos.add(Jogo(100,"Residente Evil",5.0f,"PS4"))
            jogos.add(Jogo(110,"Zombie Army 4",5.0f,"PC"))
            jogos.add(Jogo(120,"The Last of Us",5.0f,"PS4"))
            jogos.add(Jogo(130,"Red Dead Redemption",5.0f,"PC"))
            jogos.add(Jogo(140,"Clash Royal",4.0f,"Mobile"))
            jogos.add(Jogo(150,"Project Zomboid",5.0f,"PC"))
            jogos.add(Jogo(160,"Hallo",3.0f,"XBOX"))
            jogos.add(Jogo(170,"QUantum Break",4.0f,"PC"))
            jogos.add(Jogo(180,"Civilization",3.0f,"PC"))
            jogos.add(Jogo(190,"Gears of War 5",2.0f,"XOB-ONE"))
            jogos.add(Jogo(200,"Slipter.io",5.0f,"PC"))

            return jogos
        }
    }
}