package com.estudo.pokedexapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.estudo.pokedexapp.databinding.ItemPokemonBinding
import com.estudo.pokedexapp.domain.model.PokemonListItem

class PokemonAdapter(
    private val onItemClick: (PokemonListItem) -> Unit
): ListAdapter<PokemonListItem, PokemonAdapter.PokemonViewHolder>(DiffCallback) {

    inner class PokemonViewHolder(
        private val binding: ItemPokemonBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonListItem) {
            binding.textName.text = item.name.replaceFirstChar { it.uppercase() }
            binding.imagePokemon.load(item.imageUrl)

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PokemonListItem>() {
        override fun areItemsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PokemonListItem, newItem: PokemonListItem): Boolean {
            return oldItem == newItem
        }
    }
}