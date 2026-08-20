package com.estudo.appcar.shared.vehicle

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class VehicleStatusRepository {
    suspend fun getMockStatus(): VehicleStatus {
        delay(2000)

        if (Random.nextBoolean()) {
            throw Exception("Falha ao conectar com o veículo. Verifique a conexão.")
        }

        return withContext(Dispatchers.IO) {
            VehicleStatus(
                speedKmh = 10,
                batteryOfFuelPercent = 78,
                externalTempC = 24,
                isEletric = true
            )
        }
    }
}