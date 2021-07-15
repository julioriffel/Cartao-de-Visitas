/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartaoVisitaDao {
    @Query(value = "SELECT * FROM CartaoVisita ")
    fun getAll(): LiveData<List<CartaoVisita>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cartao: CartaoVisita)
}