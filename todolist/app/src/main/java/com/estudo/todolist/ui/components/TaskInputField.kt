package com.estudo.todolist.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskInputField(
    newTask: String,
    onValueChange: (String) -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = newTask,
            onValueChange = onValueChange,
            modifier = Modifier.weight(2f),
            label = { Text("New task") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(onClick = onAddClick) {
            Text("Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskInputFieldPreview() {
    TaskInputField(
        newTask = "",
        onValueChange = {},
        onAddClick = {}
    )
}
