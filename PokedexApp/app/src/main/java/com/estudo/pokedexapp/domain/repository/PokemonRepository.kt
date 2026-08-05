package com.estudo.pokedexapp.domain.repository

import com.estudo.pokedexapp.domain.model.Pokemon
import com.estudo.pokedexapp.domain.model.PokemonListItem

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonListItem>
    suspend fun getPokemonDetails(nameOrId: String): Pokemon
}