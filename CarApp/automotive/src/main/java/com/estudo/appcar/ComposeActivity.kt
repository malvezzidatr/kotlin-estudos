package com.estudo.appcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.estudo.appcar.shared.vehicle.VehicleStatusViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Mesma tela que a MainActivity (XML), só que em Compose,
 * pra comparar as duas abordagens lado a lado.
 */
class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        VehicleStatusScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun VehicleStatusScreen(
    viewModel: VehicleStatusViewModel = viewModel(),
) {
    val status by viewModel.status.observeAsState()

    status?.let {
        Text(text = "${it.speedKmh} km/h", fontSize = 32.sp)
    }

}