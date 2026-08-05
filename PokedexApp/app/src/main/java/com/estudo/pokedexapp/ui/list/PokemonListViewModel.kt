package com.estudo.pokedexapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.pokedexapp.domain.model.PokemonListItem
import com.estudo.pokedexapp.domain.model.UiState
import com.estudo.pokedexapp.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<PokemonListItem>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<PokemonListItem>>> = _uiState

    init {
        loadPokemonList()
    }

    fun loadPokemonList() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val list = getPokemonListUseCase()
                _uiState.value = UiState.Success(list)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}