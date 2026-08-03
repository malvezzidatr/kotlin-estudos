package com.estudo.myapplication.shared

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template

class DetalhesScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder("Aqui você pode colocar mais detalhes no futuro, como histórico ou gráficos.")
            .setHeaderAction(Action.BACK)
            .setTitle("Detalhes")
            .build()
    }
}