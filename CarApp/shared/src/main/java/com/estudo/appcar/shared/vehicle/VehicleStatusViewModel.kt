package com.estudo.appcar.shared.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VehicleStatusViewModel : ViewModel() {
    private val repository = VehicleStatusRepository()
    private val _status = MutableLiveData<VehicleStatus>()
    val status: LiveData<VehicleStatus> = _status

    init {
        loadStatus()
    }

    private fun loadStatus() {
        _status.value = repository.getMockStatus()
    }
}