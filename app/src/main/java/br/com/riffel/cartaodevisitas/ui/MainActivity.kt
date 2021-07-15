/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.riffel.cartaodevisitas.App
import br.com.riffel.cartaodevisitas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvCards.adapter = adapter
        getAll()
        initListeners()
    }

    private fun initListeners() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddCartaoActivity::class.java))
        }
    }

    private fun getAll() {
        mainViewModel.getAll().observe(this, { cartoesVisita ->
            adapter.submitList(cartoesVisita)
        })
    }
}