package com.estudo.myapplication.shared.car.screens

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template

class MyCarDetailsScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder("Aqui você pode colocar mais detalhes no futuro, como histórico ou gráficos.")
            .setHeaderAction(Action.BACK)
            .setTitle("Detalhes")
            .build()
    }
}