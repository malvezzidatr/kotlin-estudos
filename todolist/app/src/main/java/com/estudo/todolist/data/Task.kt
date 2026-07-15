package com.estudo.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val title: String,
    val category: String,
    val dueDate: Long,
    val progress: Float,
    val completed: Boolean = false,
)