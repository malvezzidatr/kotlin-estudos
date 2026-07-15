package com.estudo.todolist.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.estudo.todolist.data.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onToggleCompleted: (Task) -> Unit,
    onRemove: (Task) -> Unit,
    onTaskClick: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    Column() {
        LazyColumn {
            items(tasks, key = { it.id }) { task ->
                TaskItem(
                    task,
                    onToggleCompleted = { onToggleCompleted(task) },
                    onRemove = { onRemove(task) },
                    onClick = { onTaskClick(task) }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TaskListPreview() {
//    val tasksFake = listOf(
//        Task(id = 1, description = "Comprar leite", completed = false),
//        Task(id = 2, description = "Estudar Kotlin", completed = true),
//        Task(id = 3, description = "Fazer exercício", completed = true)
//    )
//
//    TaskList(
//        tasks = tasksFake,
//        onToggleCompleted = {},
//        onRemove = {},
//        onTaskClick = {}
//    )
//}
