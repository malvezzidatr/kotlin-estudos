package com.estudo.todolist.ui.screens.AddTaskSheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.todolist.data.TaskRepository
import kotlinx.coroutines.launch

class AddTaskSheetViewModel(private val repository: TaskRepository) : ViewModel() {
    fun addTask(title: String, description: String, category: String) {
        viewModelScope.launch {
            repository.addTask(
                title = title,
                description = description,
                category = category,
                dueDate = System.currentTimeMillis()
            )
        }
    }
}