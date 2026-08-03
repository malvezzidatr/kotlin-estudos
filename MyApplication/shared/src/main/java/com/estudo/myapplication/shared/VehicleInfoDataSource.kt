package com.estudo.myapplication.shared

import androidx.car.app.CarContext
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.info.EnergyLevel
import androidx.car.app.hardware.info.Speed
import androidx.core.content.ContextCompat

class VehicleInfoDataSource(private val carContext: CarContext) {
    private val carInfo = carContext.getCarService(CarHardwareManager::class.java).carInfo

    fun observeSpeed(onSpeedChange: (Speed) -> Unit) {
        carInfo.addSpeedListener(
            ContextCompat.getMainExecutor(carContext),
            onSpeedChange
        )
    }

    fun observeEnergyLevel(onEnergyChange: (EnergyLevel) -> Unit) {
        carInfo.addEnergyLevelListener(
            ContextCompat.getMainExecutor(carContext),
            onEnergyChange
        )
    }
}