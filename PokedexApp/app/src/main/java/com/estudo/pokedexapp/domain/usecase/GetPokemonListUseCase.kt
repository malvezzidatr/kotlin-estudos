package com.estudo.pokedexapp.domain.usecase

import com.estudo.pokedexapp.domain.model.PokemonListItem
import com.estudo.pokedexapp.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(limit: Int = 20, offset: Int = 0): List<PokemonListItem> {
        return repository.getPokemonList(limit, offset)
    }
}