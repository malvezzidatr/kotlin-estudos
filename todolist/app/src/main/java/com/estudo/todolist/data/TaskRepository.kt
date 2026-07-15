package com.estudo.todolist.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    val tasks: Flow<List<Task>> = dao.observableTasks()

    fun observableTaskById(taskId: Int): Flow<Task?> {
        return dao.observableTaskById(taskId)
    }

    fun observableInProgressTasks(): Flow<List<Task>> {
        return dao.observableInProgressTasks()
    }

    fun observableToDoTasks(): Flow<List<Task>> {
        return dao.observableToDoTasks()
    }

    suspend fun updateDescription(task: Task, newDescription: String) {
        dao.update(task.copy(description = newDescription))
    }

    suspend fun addTask(
        title: String,
        description: String,
        category: String,
        dueDate: Long,
        progress: Float = 0f
    ) {
        dao.insert(
            Task(
                title = title,
                description = description,
                category = category,
                dueDate = dueDate,
                progress = progress
            )
        )
    }

    suspend fun updateProgress(task: Task, newProgress: Float) {
        val clamped = newProgress.coerceIn(0f, 1f)
        dao.update(task.copy(progress = clamped, completed = clamped >= 1f))
    }

    suspend fun toggleCompleted(task: Task) {
        dao.update(task.copy(completed = !task.completed))
    }

    suspend fun removeTask(task: Task) {
        dao.delete(task)
    }
}