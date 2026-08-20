package com.estudo.appcar.shared.vehicle

data class VehicleStatus(
    val speedKmh: Int,
    val batteryOfFuelPercent: Int,
    val externalTempC: Int,
    val isEletric: Boolean
)