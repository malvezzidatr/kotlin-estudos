package com.estudo.myapplication.shared.car

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session
import com.estudo.myapplication.shared.AppContainer
import com.estudo.myapplication.shared.car.screens.MyCarAppScreen

class MyCarAppSession : Session() {

    private lateinit var appContainer: AppContainer

    override fun onCreateScreen(intent: Intent): Screen {
        appContainer = AppContainer(carContext)

        return MyCarAppScreen(
            carContext = carContext,
            viewModel = appContainer.vehicleDashboardViewModel
        )
    }
}