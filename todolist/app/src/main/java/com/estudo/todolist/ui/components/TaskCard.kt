package com.estudo.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskCard(
    category: String,
    title: String,
    time: String,
    footerRight: String,
    backgroundColor: Color,
    showEditIcon: Boolean = true,
    progress: Float? = null,
    modifier: Modifier = Modifier.width(165.dp)
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(8.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(category, fontSize = 11.sp, color = Color(0xFF879498))
            if (showEditIcon) {
                Icon(
                    modifier = Modifier.width(14.dp),
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit icon",
                    tint = Color(0xFF879498)
                )
            }
        }

        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        if (progress != null) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF6C5DD5),
                trackColor = Color(0xFFD9D4F5),
                gapSize = 0.dp,
                drawStopIndicator = {}
            )
            Spacer(Modifier.height(4.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(time, fontSize = 11.sp, color = Color(0xFF879498))
            Text(footerRight, fontSize = 11.sp, color = Color(0xFF879498))
        }
    }
}
@Preview
@Composable
fun CardPreview() {
    TaskCard(
        category = "Personal work",
        title = "Finance App Design",
        time = "10.00 AM",
        footerRight = "Today",
        backgroundColor = Color(0xFFE6FFE0),
        progress = null
    )

    TaskCard(
        category = "Client Work",
        title = "Felix Website Design",
        time = "till Friday 8.00 AM",
        footerRight = "60%",
        backgroundColor = Color(0xFFE6E1FF),
        progress = 0.60f,
        modifier = Modifier.width(240.dp)
    )
}