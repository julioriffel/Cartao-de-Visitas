/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.riffel.cartaodevisitas.data.CartaoVisita
import br.com.riffel.cartaodevisitas.data.CartaoVisitaRepository

class MainViewModel(private val cartaoVisitaRepository: CartaoVisitaRepository) : ViewModel() {
    fun insert(cartaoVisita: CartaoVisita) {
        cartaoVisitaRepository.insert(cartaoVisita)
    }


    fun getAll(): LiveData<List<CartaoVisita>> {
        return cartaoVisitaRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unlnown ViewModel class")
    }

}