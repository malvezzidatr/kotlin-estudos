package com.estudo.myapplication.shared

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.IconCompat

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
        val speedIcon = CarIcon.Builder(
            IconCompat.createWithResource(carContext, android.R.drawable.ic_menu_compass)
        ).build()

        val fuelIcon = CarIcon.Builder(
            IconCompat.createWithResource(carContext, android.R.drawable.ic_menu_send)
        ).build()

        val speedRow = Row.Builder()
            .setTitle("Velocidade")
            .addText("%.1f km/h".format(speedKmh))
            .setImage(speedIcon)
            .build()

        val fuelRow = Row.Builder()
            .setTitle("Combustível")
            .addText("%.1f%%".format(currentFuelPercent))
            .setImage(fuelIcon)
            .build()

        val detalhesRow = Row.Builder()
            .setTitle("Ver mais detalhes")
            .addText("Toque para abrir")
            .setOnClickListener {
                screenManager.push(DetalhesScreen(carContext))
            }
            .build()

        val itemList = ItemList.Builder()
            .addItem(speedRow)
            .addItem(fuelRow)
            .addItem(detalhesRow)
            .build()

        return ListTemplate.Builder()
            .setSingleList(itemList)
            .setHeaderAction(Action.APP_ICON)
            .setTitle("Painel do Veículo")
            .build()
    }
}