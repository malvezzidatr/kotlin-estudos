package com.estudo.todolist.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    val tasks: Flow<List<Task>> = dao.observableTasks()

    suspend fun addTask(description: String) {
        dao.insert(Task(description = description))
    }

    suspend fun toggleCompleted(task: Task) {
        dao.update(task.copy(completed = !task.completed))
    }

    suspend fun removeTask(task: Task) {
        dao.delete(task)
    }
}