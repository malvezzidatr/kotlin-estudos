package com.estudo.todolist.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    val tasks: Flow<List<Task>> = dao.observableTasks()

    fun observableTaskById(taskId: Int): Flow<Task?> {
        return dao.observableTaskById(taskId)
    }

    suspend fun updateDescription(task: Task, newDescription: String) {
        dao.update(task.copy(description = newDescription))
    }

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