package com.estudo.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.estudo.todolist.ui.navigation.NavGraph
import com.estudo.todolist.ui.screens.Home.TaskScreen
import com.estudo.todolist.ui.screens.Home.TaskViewModel
import com.estudo.todolist.ui.theme.TodolistTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavGraph()
        }
    }
}
