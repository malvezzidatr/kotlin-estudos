package com.estudo.todolist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estudo.todolist.data.Task
import com.estudo.todolist.ui.components.TaskInputField
import com.estudo.todolist.ui.components.TaskList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    var newTask by remember { mutableStateOf("") }

    TaskScreenContent(
        tasks = tasks,
        newTask = newTask,
        onNewTaskChange = { newTask = it },
        onAddClick = {
            viewModel.addTask(newTask)
            newTask = ""
        },
        onToggleCompleted = { viewModel.toggleCompleted(it) },
        onRemove = { viewModel.removeTask(it) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreenContent(
    tasks: List<Task>,
    newTask: String,
    onNewTaskChange: (String) -> Unit,
    onAddClick: () -> Unit,
    onToggleCompleted: (Task) -> Unit,
    onRemove: (Task) -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("My Tasks") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            TaskInputField(
                newTask = newTask,
                onValueChange = onNewTaskChange,
                onAddClick = onAddClick
            )
            Spacer(modifier = Modifier.height(16.dp))
            TaskList(
                tasks = tasks,
                onToggleCompleted = onToggleCompleted,
                onRemove = onRemove
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskScreenContentPreview() {
    TaskScreenContent(
        tasks = listOf(
            Task(id = 1, description = "Comprar leite", completed = false),
            Task(id = 2, description = "Estudar Kotlin", completed = true)
        ),
        newTask = "",
        onNewTaskChange = {},
        onAddClick = {},
        onToggleCompleted = {},
        onRemove = {}
    )
}