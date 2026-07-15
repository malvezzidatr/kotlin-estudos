package com.estudo.todolist.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estudo.todolist.data.Task

@Composable
fun TaskCarousel(
    tasks: List<Task>,
    progress: Float? = null,
    backgroundColor: Color
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(tasks.size) { task ->
            TaskCard(
                category = "teste",
                title = "Teste",
                time = "10h00AM",
                footerRight = "Today",
                backgroundColor = backgroundColor,
                progress = progress
            )
        }
    }
}

@Preview
@Composable
fun TaskCarouselPreview() {
    val tasksFake = listOf(
        Task(
            id = 1,
            title = "Comprar leite",
            description = "Ir ao mercado e comprar leite integral",
            category = "Personal work",
            dueDate = System.currentTimeMillis(),
            progress = 0f,
            completed = false
        ),
        Task(
            id = 2,
            title = "Estudar Kotlin",
            description = "Revisar coroutines e Flow",
            category = "Office work",
            dueDate = System.currentTimeMillis(),
            progress = 1f,
            completed = true
        ),
        Task(
            id = 3,
            title = "Fazer exercício",
            description = "Treino de pernas na academia",
            category = "Client Work",
            dueDate = System.currentTimeMillis(),
            progress = 1f,
            completed = true
        ),
        Task(
            id = 4,
            title = "Felix Website Design",
            description = "Finalizar layout do site do cliente",
            category = "Client Work",
            dueDate = System.currentTimeMillis(),
            progress = 0.56f,
            completed = false
        )
    )


    TaskCarousel(tasksFake, null, Color(0xFFE6FFE0))
    TaskCarousel(tasksFake, 60f, Color(0xFFE6FFE0))
}