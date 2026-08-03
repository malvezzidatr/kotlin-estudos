package com.estudo.myapplication.shared

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.model.Action
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.content.ContextCompat

class MyCarAppScreen(carContext: CarContext) : Screen(carContext) {
    private var currentSpeed: Float = 0f
    private var currentFuelPercent: Float = 0f

    init {
        val carHardwareManager = carContext.getCarService(CarHardwareManager::class.java)
        val carInfo = carHardwareManager.carInfo

        carInfo.addSpeedListener(
            ContextCompat.getMainExecutor(carContext)
        ) {
            speedData -> currentSpeed = speedData.rawSpeedMetersPerSecond.value ?: 0f
            invalidate()
        }

        carInfo.addEnergyLevelListener(
            ContextCompat.getMainExecutor(carContext)
        ) {
            energyData -> currentFuelPercent = energyData.fuelPercent.value ?: 0f
            invalidate()

        }
    }
    override fun onGetTemplate(): Template {
        val speedKmh = currentSpeed * 3.6f
        val message = "Velocidade: %.1f km/h\nCombustível: %.1f%%".format(speedKmh, currentFuelPercent)
        val speedRow = Row.Builder()
            .setTitle("Velocidade")
            .addText("%.1f km/h".format(speedKmh))
            .build()

        val fuelRow = Row.Builder()
            .setTitle("Combustível")
            .addText("%.1f%%".format(currentFuelPercent))
            .build()

        val pane = Pane.Builder()
            .addRow(speedRow)
            .addRow(fuelRow)
            .build()

        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.APP_ICON)
            .setTitle("Painel do Veículo")
            .build()
    }
}