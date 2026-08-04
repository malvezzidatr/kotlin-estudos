package com.estudo.pokedexapp.data.remote

import com.squareup.moshi.Json

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: SpritesDTO,
    val types: List<PokemonTypeSlotDTO>
)

data class SpritesDTO(
    @Json(name = "front_default")
    val frontDefault: String?
)

data class PokemonTypeSlotDTO(
    val slot: Int,
    val type: TypeDTO,
)

data class TypeDTO(
    val name: String,
)