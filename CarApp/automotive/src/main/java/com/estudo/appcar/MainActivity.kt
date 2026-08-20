package com.estudo.appcar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.estudo.appcar.shared.vehicle.VehicleStatusUiState
import com.estudo.appcar.shared.vehicle.VehicleStatusViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var helloText: TextView
    private lateinit var composeButton: Button
    private val viewModel: VehicleStatusViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloText = findViewById(R.id.textOla)
        viewModel.uiState.observe(this) { vehicleStatus ->
            when (vehicleStatus) {
                is VehicleStatusUiState.Loading -> helloText.text = "Loading..."
                is VehicleStatusUiState.Error -> {
                    helloText.text = vehicleStatus.message
                }
                is VehicleStatusUiState.Success -> {
                    helloText.text = "${vehicleStatus.status.speedKmh} km/h"
                }
            }
        }

        composeButton = findViewById(R.id.btnCompose)
        composeButton.setOnClickListener {
            startActivity(Intent(this, ComposeActivity::class.java))
        }
    }
}
