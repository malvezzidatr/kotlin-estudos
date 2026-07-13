package com.estudo.todolist.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estudo.todolist.data.Task

@Composable
fun TaskItem(
    task: Task,
    onRemove: () -> Unit,
    onToggleCompleted: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = task.completed,
            onCheckedChange = { onToggleCompleted() }
        )
        Text(
            text = task.description,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onRemove() }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    TaskItem(
        task = Task(id = 1, description = "Comprar leite", completed = false),
        onToggleCompleted = {},
        onRemove = {}
    )
}