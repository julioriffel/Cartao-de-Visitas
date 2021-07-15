/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitaRepository(private val dao: CartaoVisitaDao) {
    fun insert(cartaoVisita: CartaoVisita) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cartaoVisita)
        }
    }

    fun getAll() = dao.getAll()
}