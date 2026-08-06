package com.estudo.myapplication.shared.presentation

import com.estudo.myapplication.shared.domain.usecase.ObserveVehicleStatusUseCase
import com.estudo.myapplication.shared.domain.model.VehicleStatus

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