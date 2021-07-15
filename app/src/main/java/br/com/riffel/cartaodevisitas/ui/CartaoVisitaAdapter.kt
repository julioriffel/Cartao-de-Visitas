/*
 * Copyright (c) 2021.
 * Julio Cezar Riffel<julioriffel@gmail.com>
 */

package br.com.riffel.cartaodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.riffel.cartaodevisitas.data.CartaoVisita
import br.com.riffel.cartaodevisitas.databinding.ItemCartaoBinding

class CartaoVisitaAdapter :
    ListAdapter<CartaoVisita, CartaoVisitaAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCartaoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartaoVisita) {
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.empresa
            binding.tvTelefone.text = item.telefone
            binding.mcvContent.setOnClickListener { listenerShare(it) }
            try {
                binding.mcvContent.setBackgroundColor(Color.parseColor(item.cor))
            } catch (e: Exception) {
            }

        }
    }


}

class DiffCallback : DiffUtil.ItemCallback<CartaoVisita>() {
    override fun areItemsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem == newItem
    override fun areContentsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) =
        oldItem.id == newItem.id
}
