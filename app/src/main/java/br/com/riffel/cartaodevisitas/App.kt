/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas

import android.app.Application
import br.com.riffel.cartaodevisitas.data.AppDatabase
import br.com.riffel.cartaodevisitas.data.CartaoVisitaRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoVisitaRepository(database.businessDao()) }
}