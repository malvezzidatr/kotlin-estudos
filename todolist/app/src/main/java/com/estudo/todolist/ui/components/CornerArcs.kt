package com.estudo.todolist.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CornerArcs(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    lineCount: Int = 5,
    startAngle: Float = 0f,
) {
    Canvas(modifier = modifier.size(300.dp)) {
        val strokeWidth = 1.dp.toPx()
        val spacing = size.minDimension / lineCount

        for (i in 0 until lineCount) {
            val radius = size.minDimension - (i * spacing)
            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(
                    x = -radius / 2,
                    y = -radius / 2
                ),
                size = Size(radius, radius),
                style = Stroke(width = strokeWidth)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CornerArcsPreview() {
    CornerArcs()
}