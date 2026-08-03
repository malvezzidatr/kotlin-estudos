package com.estudo.myapplication.shared

class ObserveVehicleStatusUseCase(private val repository: VehicleRepository) {
    private var lastSpeed = 0f
    private var lastFuel = 0f

    operator fun invoke(onStatusChanged: (VehicleStatus) -> Unit) {
        repository.observeSpeedKmh { speed ->
            lastSpeed = speed
            emitStatus(onStatusChanged)
        }

        repository.observeEnergyPercent { fuel ->
            lastFuel = fuel
            emitStatus(onStatusChanged)
        }
    }

    private fun emitStatus(onStatusChanged: (VehicleStatus) -> Unit) {
        val status = VehicleStatus(
            lastSpeed,
            lastFuel,
            lastFuel < 15f
        )
        onStatusChanged(status)
    }
}