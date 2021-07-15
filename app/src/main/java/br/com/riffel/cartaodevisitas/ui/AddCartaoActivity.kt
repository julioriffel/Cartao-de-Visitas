/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.riffel.cartaodevisitas.databinding.ActivityAddCartaoBinding

class AddCartaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCartaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCartaoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()

    }

    private fun initListeners() {
        binding.btClose.setOnClickListener {
            finish()
        }
        binding.btSalvar.setOnClickListener {
            finish()
        }
    }
}