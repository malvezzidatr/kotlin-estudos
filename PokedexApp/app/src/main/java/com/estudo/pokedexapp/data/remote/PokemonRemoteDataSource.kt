package com.estudo.pokedexapp.data.remote

import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val apiService: PokeApiService
) {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonListResponseDTO {
        return apiService.getPokemonList(limit, offset)
    }

    suspend fun getPokemonDetail(nameOrId: String): PokemonDetailsDTO {
        return apiService.getPokemonDetail(nameOrId)
    }
}