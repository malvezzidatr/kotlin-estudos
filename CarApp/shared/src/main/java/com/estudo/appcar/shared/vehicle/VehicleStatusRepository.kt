package com.estudo.appcar.shared.vehicle

class VehicleStatusRepository {
    fun getMockStatus(): VehicleStatus {
        return VehicleStatus(
            speedKmh = 10,
            batteryOfFuelPercent = 78,
            externalTempC = 24,
            isEletric = true
        )
    }
}