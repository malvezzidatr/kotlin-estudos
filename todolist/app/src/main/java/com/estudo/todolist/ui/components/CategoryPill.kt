package com.estudo.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryPill(
    text: String,
    color: Color,
    rotationDegrees: Float = 0f,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .graphicsLayer { rotationZ = rotationDegrees }
            .clip(RoundedCornerShape(50))
            .background(color)
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(text, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPillPreview() {
    CategoryPill(
        text = "Preview",
        color = Color.Blue,
        rotationDegrees = 20f
    )
}