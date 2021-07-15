/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.riffel.cartaodevisitas.App
import br.com.riffel.cartaodevisitas.R
import br.com.riffel.cartaodevisitas.data.CartaoVisita
import br.com.riffel.cartaodevisitas.databinding.ActivityAddCartaoBinding
import br.com.riffel.cartaodevisitas.util.DataHolder


class AddCartaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCartaoBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCartaoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()
        val ct: CartaoVisita? = DataHolder.getPropriedade()
        binding.tilNome.editText?.setText(ct?.nome)
    }

    private fun initListeners() {
        binding.btClose.setOnClickListener {
            finish()
        }
        binding.btSalvar.setOnClickListener {
            val cartaoVisita = CartaoVisita(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                cor = binding.tilCor.editText?.text.toString(),
            )
            mainViewModel.insert(cartaoVisita)
            Toast.makeText(this, R.string.label_sucesso, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}