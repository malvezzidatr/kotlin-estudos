package com.estudo.appcar.shared.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class VehicleStatusViewModel : ViewModel() {
    private val repository = VehicleStatusRepository()
    private val _uiState = MutableLiveData<VehicleStatusUiState>()
    val uiState: LiveData<VehicleStatusUiState> = _uiState

    init {
        loadStatus()
    }

    private fun loadStatus() {
        _uiState.value = VehicleStatusUiState.Loading

        viewModelScope.launch {
            try {
                val status = repository.getMockStatus()
                _uiState.value = VehicleStatusUiState.Success(status)
            } catch (e: Exception) {
                _uiState.value = VehicleStatusUiState.Error(
                    e.message ?: "Erro desconhecido ao buscar status do veículo"
                )
            }
        }
    }
}