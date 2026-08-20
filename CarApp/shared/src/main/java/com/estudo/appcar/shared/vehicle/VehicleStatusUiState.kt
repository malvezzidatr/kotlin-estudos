package com.estudo.appcar.shared.vehicle

sealed class VehicleStatusUiState {
    object Loading : VehicleStatusUiState()
    data class Success(val status: VehicleStatus) : VehicleStatusUiState()
    data class Error(val message: String) : VehicleStatusUiState()
}