package com.estudo.appcar.shared.vehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ClimateViewModel: ViewModel() {
    private var sensor = CabinTemperatureSensor()
    private var _desiredTempC = MutableStateFlow(22)

    val climateState: StateFlow<ClimateState> = combine(
        _desiredTempC,
        sensor.readings()
    ) { desired, current ->
        ClimateState(desiredTempC = desired, currentCabinTempC = current)
    }.stateIn(
        scope = viewModelScope,
        started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
        initialValue = ClimateState(desiredTempC = 22, currentCabinTempC = 22)
    )

    fun increaseTemp() {
        _desiredTempC.value += 1
    }

    fun decreaseTemp() {
        _desiredTempC.value -= 1
    }
}