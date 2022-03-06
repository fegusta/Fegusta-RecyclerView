package com.fegusta.fegustarecyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fegusta.fegustarecyclerview.R
import com.fegusta.fegustarecyclerview.constants.Constants
import com.fegusta.fegustarecyclerview.model.Jogo
import com.fegusta.fegustarecyclerview.ui.CadastroJogoActivity

class JogosAdapter(var listaJogos: ArrayList<Jogo>): RecyclerView.Adapter<JogosAdapter.JogoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_jogos, parent, false)

        return JogoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaJogos.size
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val jogo = listaJogos[position]
        holder.bind(jogo)

    }

    class JogoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(jogo: Jogo) {
            itemView.findViewById<TextView>(R.id.textNomeDoJogo).text = jogo.titulo
            itemView.findViewById<TextView>(R.id.textConsole).text = jogo.console
            itemView.findViewById<RatingBar>(R.id.notaJogo).rating = jogo.notaJogo
            itemView.findViewById<Button>(R.id.buttonDetalhes).setOnClickListener {
                val intent = Intent(itemView.context, CadastroJogoActivity::class.java)
                intent.putExtra("operacao", Constants.OPERACAO_CONSULTAR)
                intent.putExtra("id",jogo.id)
                itemView.context.startActivity(intent)
            }
        }
    }
}