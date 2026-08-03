package com.estudo.myapplication.shared

data class VehicleStatus(
    val speedKmh: Float,
    val fuelPercent: Float,
    val isFuelLow: Boolean,
    val estimateRange: Float,
)