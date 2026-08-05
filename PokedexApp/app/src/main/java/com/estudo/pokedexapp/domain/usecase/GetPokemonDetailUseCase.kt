package com.estudo.pokedexapp.domain.usecase

import com.estudo.pokedexapp.domain.model.Pokemon
import com.estudo.pokedexapp.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(nameOrId: String): Pokemon {
        return repository.getPokemonDetails(nameOrId)
    }
}