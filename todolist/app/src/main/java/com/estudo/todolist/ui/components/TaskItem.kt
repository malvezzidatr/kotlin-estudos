package com.estudo.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estudo.todolist.data.Task

@Composable
fun TaskItem(
    task: Task,
    onRemove: () -> Unit,
    onClick: () -> Unit,
    onToggleCompleted: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
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

//@Preview
//@Composable
//fun TaskItemPreview() {
//    TaskItem(
//        task = Task(id = 1, description = "Comprar leite", completed = false),
//        onToggleCompleted = {},
//        onRemove = {},
//        onClick = {},
//    )
//}