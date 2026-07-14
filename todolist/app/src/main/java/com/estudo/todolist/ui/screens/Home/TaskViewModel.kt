package com.estudo.todolist.ui.screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.todolist.data.Task
import com.estudo.todolist.data.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val uiState: StateFlow<TaskUiState> = repository.tasks
        .map<List<Task>, TaskUiState> { tasks -> TaskUiState.Success(tasks) }
        .catch { error -> emit(TaskUiState.Error(error.message ?: "Erro desconhecido")) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = TaskUiState.Loading
        )
    val tasks: StateFlow<List<Task>> = repository.tasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(description: String) {
        if (description.isBlank()) return
        viewModelScope.launch {
            repository.addTask(description)
        }
    }

    fun toggleCompleted(task: Task) {
        viewModelScope.launch {
            repository.toggleCompleted(task)
        }
    }

    fun removeTask(task: Task) {
        viewModelScope.launch {
            repository.removeTask(task)
        }
    }
}