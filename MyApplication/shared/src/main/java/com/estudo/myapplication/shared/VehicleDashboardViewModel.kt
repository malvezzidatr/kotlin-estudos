package com.estudo.myapplication.shared

class VehicleDashboardViewModel(
    private val observeVehicleStatusUseCase: ObserveVehicleStatusUseCase
) {
    var vehicleStatus: VehicleStatus = VehicleStatus(0f, 0f, false, 0f)
        private set

    fun start(onUpdated: () -> Unit) {
        observeVehicleStatusUseCase { status ->
            vehicleStatus = status
            onUpdated()
        }
    }
}