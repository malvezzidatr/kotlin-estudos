package com.estudo.appcar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.estudo.appcar.shared.vehicle.ClimateViewModel
import com.estudo.appcar.shared.vehicle.VehicleStatusUiState
import com.estudo.appcar.shared.vehicle.VehicleStatusViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var actualTempC: TextView
    private lateinit var desiredTempC: TextView
    private lateinit var increaseButton: Button
    private lateinit var decreaseButton: Button
    private val viewModel: VehicleStatusViewModel by viewModels()
    private val climateViewModel: ClimateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inflateComponents()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                climateViewModel.climateState.collect { state ->
                    actualTempC.text = "${state.currentCabinTempC}ºC"
                    desiredTempC.text = "${state.desiredTempC}ºC"
                }
            }
        }
    }
    private fun inflateComponents() {
        decreaseButton = findViewById(R.id.btnDecrease)
        increaseButton = findViewById(R.id.btnIncrease)
        actualTempC = findViewById(R.id.actualTempText)
        desiredTempC = findViewById(R.id.desiredTempText)

        decreaseButton.setOnClickListener {
            climateViewModel.decreaseTemp()
        }

        increaseButton.setOnClickListener {
            climateViewModel.increaseTemp()
        }
    }
}
