package com.estudo.myapplication.shared.domain.repository

interface VehicleRepository {
    fun observeSpeedKmh(onSpeedChange: (Float) -> Unit)
    fun observeEnergyPercent(onFuelChange: (Float) -> Unit)
    fun observeRangeRemainingKm(onRangeChanged: (Float?) -> Unit)
}