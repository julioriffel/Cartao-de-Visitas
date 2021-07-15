/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.util


import br.com.riffel.cartaodevisitas.data.CartaoVisita


object DataHolder {

    private var propriedade: CartaoVisita? = null


    fun getPropriedade(): CartaoVisita? {
        return propriedade
    }

    fun setPropriedade(propriedade: CartaoVisita?) {
        DataHolder.propriedade = propriedade
    }


}