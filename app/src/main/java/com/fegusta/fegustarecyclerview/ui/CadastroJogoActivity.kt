package com.fegusta.fegustarecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.fegusta.fegustarecyclerview.R
import com.fegusta.fegustarecyclerview.constants.Constants
import com.fegusta.fegustarecyclerview.datasource.DatabaseDefinitions
import com.fegusta.fegustarecyclerview.model.Jogo
import com.fegusta.fegustarecyclerview.repository.JogoRepository
import com.google.android.material.textfield.TextInputLayout

class CadastroJogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_jogo)

        insertToolbar()

        if(intent.getStringExtra("operacao") != Constants.OPERACAO_NOVO_CADASTRO){
            preencherFormulatio()
        }
    }

    private fun preencherFormulatio() {
        var jogo = Jogo()
        var id = intent.getIntExtra("id",0)

        val repository = JogoRepository(this)

        jogo = repository.getJogo(id)

        findViewById<TextView>(R.id.editTextNomeDoJogo).setText(jogo.titulo)
        findViewById<TextView>(R.id.editTextProdutoraDoJogo).setText(jogo.produtora)
        findViewById<RatingBar>(R.id.ratingBarNotaDoJogo).rating = jogo.notaJogo
        findViewById<CheckBox>(R.id.checkBoxZerado).isChecked = jogo.zerado


    }

    private fun insertToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = intent.getStringExtra("operacao")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_cancelar -> {
                alert()
            }
            R.id.menu_salvar -> {
                if(validarFormulario()){
                    salvarJogo()
                }
            }
            else -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun salvarJogo() {
        val jogo = Jogo(
            titulo = findViewById<TextView>(R.id.editTextNomeDoJogo).text.toString(),
            produtora = findViewById<TextView>(R.id.editTextProdutoraDoJogo).text.toString(),
            notaJogo = findViewById<RatingBar>(R.id.ratingBarNotaDoJogo).rating,
            console = findViewById<Spinner>(R.id.spinnerConsole).selectedItem.toString(),
            zerado = findViewById<CheckBox>(R.id.checkBoxZerado).isChecked,
        )

        val repo = JogoRepository(this)
        val id = repo.save(jogo)
        if (id > 0) {
            val builderDialog = AlertDialog.Builder(this)
            builderDialog.setTitle("Sucesso!")
            builderDialog.setMessage("Seu jogo foi gravado com sucesso!\n\nDeseja cadastrar outro jogo?")
            builderDialog.setIcon(R.drawable.ic_baseline_done_24)

            builderDialog.setPositiveButton("Sim") { _, _ ->
                limparFormulario()
            }

            builderDialog.setNegativeButton("Não") { _, _ ->
                onBackPressed()
            }

            builderDialog.show()
        }
    }

    private fun limparFormulario() {
        findViewById<TextView>(R.id.editTextNomeDoJogo).setText("")
        findViewById<TextView>(R.id.editTextProdutoraDoJogo).setText("")
        findViewById<CheckBox>(R.id.checkBoxZerado).isChecked = false
        findViewById<TextView>(R.id.editTextNomeDoJogo).requestFocus()
    }

    private fun alert() {
        var builderDialog = AlertDialog.Builder(this)
        builderDialog.setTitle("Cancelar Cadastro")
        builderDialog.setMessage("Tem certeza que deseja cancelar o cadastro do seu jogo?")
        builderDialog.setIcon(R.drawable.ic_baseline_help_outline_red__24)

        builderDialog.setPositiveButton("Sim") {_,_ ->
            onBackPressed()
        }

        builderDialog.setNegativeButton("Não") {_,_ ->
            findViewById<EditText>(R.id.editTextNomeDoJogo).requestFocus()
        }

        builderDialog.show()
    }

    private fun validarFormulario() : Boolean {

        var valida = true

        if (findViewById<EditText>(R.id.editTextNomeDoJogo).length() < 3){
            findViewById<TextInputLayout>(R.id.tilNomedoJogo).error = getString(R.string.msg_valida_cadastro_titulo_jogo)
            valida = false
            return valida
        } else {
            findViewById<TextInputLayout>(R.id.tilNomedoJogo).error = null
        }

        if (findViewById<EditText>(R.id.editTextProdutoraDoJogo).length() < 3){
            findViewById<TextInputLayout>(R.id.tilProdutoradoJogo).error = getString(R.string.msg_valida_cadastroJogo_form_produtora_jogo)
            valida = false
            return valida
        } else {
            findViewById<TextInputLayout>(R.id.tilProdutoradoJogo).error = null
        }

        return valida
    }
}