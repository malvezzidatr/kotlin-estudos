package com.estudo.todolist.ui.screens.TaskDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.todolist.data.Task
import com.estudo.todolist.data.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskDetailViewModel(
    private val repository: TaskRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val taskId: Int = checkNotNull(savedStateHandle["taskId"])

    val task: StateFlow<Task?> = repository.observableTaskById(taskId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000),
            initialValue = null
        )

    fun updateDescription(newDescription: String) {
        val actualTask = task.value ?: return
        viewModelScope.launch {
            repository.updateDescription(actualTask, newDescription)
        }
    }
}