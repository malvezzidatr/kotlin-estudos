package com.estudo.pokedexapp.data.repository

import com.estudo.pokedexapp.data.remote.PokemonRemoteDataSource
import com.estudo.pokedexapp.domain.model.Pokemon
import com.estudo.pokedexapp.domain.model.PokemonListItem
import com.estudo.pokedexapp.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val dataSource: PokemonRemoteDataSource
): PokemonRepository {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): List<PokemonListItem> {
        val response = dataSource.getPokemonList(limit, offset)

        return response.results.map {item ->
            val id = extractIdFromUrl(item.url)
            PokemonListItem(
                id = id,
                name = item.name,
                imageUrl = buildImageUrl(id),
            )
        }
    }

    override suspend fun getPokemonDetails(nameOrId: String): Pokemon {
        val dto = dataSource.getPokemonDetail(nameOrId)

        return Pokemon(
            id = dto.id,
            name = dto.name,
            imageUrl = dto.sprites.frontDefault ?: buildImageUrl(dto.id),
            height = dto.height,
            weight = dto.weight,
            types = dto.types.map { it.type.name }
        )
    }

    private fun extractIdFromUrl(url: String): Int {
        return url.trimEnd('/').substringAfterLast('/').toInt()
    }

    private fun buildImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    }
}