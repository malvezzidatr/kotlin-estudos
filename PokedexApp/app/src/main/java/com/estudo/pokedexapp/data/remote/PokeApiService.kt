package com.estudo.pokedexapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonListResponseDTO

    @GET("pokemon/{nameOrId}")
    suspend fun getPokemonDetail(
        @Path("nameOrId") nameOrId: String
    ): PokemonDetailsDTO
}