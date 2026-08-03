package com.estudo.myapplication.shared

class ObserveVehicleStatusUseCase(private val repository: VehicleRepository) {
    private var lastSpeed = 0f
    private var lastFuel = 0f
    private var lastRangeFromVehicle: Float? = null

    operator fun invoke(onStatusChanged: (VehicleStatus) -> Unit) {
        repository.observeSpeedKmh { speed ->
            lastSpeed = speed
            emitStatus(onStatusChanged)
        }

        repository.observeEnergyPercent { fuel ->
            lastFuel = fuel
            emitStatus(onStatusChanged)
        }

        repository.observeRangeRemainingKm { range ->
            lastRangeFromVehicle = range ?: 0f
            emitStatus(onStatusChanged)
        }
    }

    private fun emitStatus(onStatusChanged: (VehicleStatus) -> Unit) {
        val status = VehicleStatus(
            lastSpeed,
            lastFuel,
            lastFuel < 15f,
            calculateRange()
        )
        onStatusChanged(status)
    }

    private fun calculateRange(): Float {
        lastRangeFromVehicle?.let { return it }

        val assumedTankCapacityKm = 500f
        return (lastFuel / 100f) * assumedTankCapacityKm
    }
}