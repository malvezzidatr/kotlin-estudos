package com.estudo.todolist.ui.screens.Home

import com.estudo.todolist.data.Task

sealed class TaskUiState {
    object Loading : TaskUiState()
    data class Success(val tasks: List<Task>) : TaskUiState()
    data class Error(val message: String) : TaskUiState()
}