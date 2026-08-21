package com.estudo.appcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.estudo.appcar.shared.vehicle.VehicleStatusViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.estudo.appcar.shared.vehicle.ClimateViewModel
import com.estudo.appcar.shared.vehicle.VehicleStatus
import com.estudo.appcar.shared.vehicle.VehicleStatusUiState

/**
 * Mesma tela que a MainActivity (XML), só que em Compose,
 * pra comparar as duas abordagens lado a lado.
 */
class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ClimateScreen()
            }
        }
    }
}

@Composable
fun ClimateScreen(
    viewModel: ClimateViewModel = viewModel()
){
    val uiState by viewModel.climateState.collectAsStateWithLifecycle()

    Column() {
        Row() {
            Text("${uiState.desiredTempC}ºC")
            Text("${uiState.currentCabinTempC}ºC")
        }
        Row() {
            Button(onClick = { viewModel.decreaseTemp() }) {
                Text("-")
            }
            Button(onClick = { viewModel.increaseTemp() }) {
                Text("+")
            }
        }
    }


}

@Composable
fun VehicleStatusScreen(
    viewModel: VehicleStatusViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is VehicleStatusUiState.Loading -> LoadingContent()
        is VehicleStatusUiState.Success -> SuccessContent(state.status)
        is VehicleStatusUiState.Error -> ErrorContent(state.message)
    }

}

@Composable
fun LoadingContent() {
    Text("Loading....", fontSize = 24.sp)
}

@Composable
fun SuccessContent(
    status: VehicleStatus
) {
    Text("${status.speedKmh} km/h", fontSize = 24.sp)
}

@Composable
fun ErrorContent(
    message: String,
) {
    Text(message, fontSize = 24.sp)
}