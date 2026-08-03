package com.estudo.myapplication.shared

class VehicleRepositoryImpl(private val dataSource: VehicleInfoDataSource) : VehicleRepository {
    override fun observeSpeedKmh(onSpeedChange: (Float) -> Unit) {
        dataSource.observeSpeed { speedData ->
            val speedMs = speedData.rawSpeedMetersPerSecond.value ?: 0f
            onSpeedChange(speedMs * 3.6f)
        }
    }

    override fun observeEnergyPercent(onFuelChange: (Float) -> Unit) {
        dataSource.observeEnergyLevel { energyLevel ->
            val fuelPercent = energyLevel.fuelPercent.value ?: 0f
            onFuelChange(fuelPercent)
        }
    }

}