package com.estudo.myapplication.shared

import androidx.car.app.CarContext
import com.estudo.myapplication.shared.data.datasource.VehicleInfoDataSource
import com.estudo.myapplication.shared.data.repository.VehicleRepositoryImpl
import com.estudo.myapplication.shared.domain.repository.VehicleRepository
import com.estudo.myapplication.shared.domain.usecase.ObserveVehicleStatusUseCase
import com.estudo.myapplication.shared.presentation.VehicleDashboardViewModel

class AppContainer(carContext: CarContext) {

    private val dataSource: VehicleInfoDataSource =
        VehicleInfoDataSource(carContext)

    private val repository: VehicleRepository =
        VehicleRepositoryImpl(dataSource)

    private val observeVehicleStatusUseCase: ObserveVehicleStatusUseCase =
        ObserveVehicleStatusUseCase(repository)

    val vehicleDashboardViewModel: VehicleDashboardViewModel =
        VehicleDashboardViewModel(observeVehicleStatusUseCase)
}