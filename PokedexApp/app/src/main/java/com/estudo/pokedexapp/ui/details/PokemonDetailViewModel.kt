package com.estudo.pokedexapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.pokedexapp.domain.model.Pokemon
import com.estudo.pokedexapp.domain.model.UiState
import com.estudo.pokedexapp.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<Pokemon>>(UiState.Loading)
    val uiState: StateFlow<UiState<Pokemon>> = _uiState

    fun loadPokemonDetail(nameOrId: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val pokemon = getPokemonDetailUseCase(nameOrId)
                _uiState.value = UiState.Success(pokemon)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }

}