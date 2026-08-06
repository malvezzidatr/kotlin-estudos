package com.estudo.myapplication.shared.domain.model

data class VehicleStatus(
    val speedKmh: Float,
    val fuelPercent: Float,
    val isFuelLow: Boolean,
    val estimateRange: Float,
)