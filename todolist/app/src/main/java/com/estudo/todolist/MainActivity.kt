package com.estudo.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.estudo.todolist.data.TaskDatabase
import com.estudo.todolist.data.TaskRepository
import com.estudo.todolist.ui.TaskScreen
import com.estudo.todolist.ui.TaskViewModel
import com.estudo.todolist.ui.theme.TodolistTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TodolistTheme {
                val viewModel: TaskViewModel = koinViewModel()
                TaskScreen(viewModel = viewModel)
            }
        }
    }
}

@Preview()
@Composable
fun TaskScreenPreview() {

}
