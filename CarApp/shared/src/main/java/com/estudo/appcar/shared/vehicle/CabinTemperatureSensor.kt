package com.estudo.appcar.shared.vehicle

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CabinTemperatureSensor {
    fun readings(): Flow<Int> = flow {
        var currentTemp = 22

        while (true) {
            delay(1500)
            currentTemp += Random.nextInt(-1, 2)
            emit(currentTemp)
        }
    }
}