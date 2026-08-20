package com.estudo.appcar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.estudo.appcar.shared.vehicle.VehicleStatusViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var helloText: TextView
    private lateinit var composeButton: Button
    private val viewModel: VehicleStatusViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloText = findViewById(R.id.textOla)
        viewModel.status.observe(this) { status ->
            helloText.text = "${status.speedKmh} km/h"
        }

        composeButton = findViewById(R.id.btnCompose)
        composeButton.setOnClickListener {
            startActivity(Intent(this, ComposeActivity::class.java))
        }
    }
}
