package com.estudo.pokedexapp.data.remote

data class PokemonListDTO(
    val results: List<PokemonListItemDTO>
)

data class PokemonListItemDTO(
    val name: String,
    val url: String,
)