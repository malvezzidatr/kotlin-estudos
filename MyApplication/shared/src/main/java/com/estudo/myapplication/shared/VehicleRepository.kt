package com.estudo.myapplication.shared

interface VehicleRepository {
    fun observeSpeedKmh(onSpeedChange: (Float) -> Unit)
    fun observeEnergyPercent(onFuelChange: (Float) -> Unit)
}
