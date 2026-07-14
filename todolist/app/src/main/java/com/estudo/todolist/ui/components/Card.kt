package com.estudo.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
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

@Composable
fun Card() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFE6FFE0))
            .padding(all = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .width(165.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Personal work",
                fontSize = 11.sp,
                color = Color(0xFF879498)
            )
            Icon(
                modifier = Modifier
                    .width(14.dp),
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit icon",
                tint = Color(0xFF879498)
            )
        }
        Text(
            modifier = Modifier
                .padding(vertical = 18.dp)
                .width(140.dp),
            text = "Finance app Design",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        Row(
            modifier = Modifier
                .width(165.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "10h00 AM",
                fontSize = 11.sp,
                color = Color(0xFF879498)
            )
            Text(
                "Today",
                fontSize = 11.sp,
                color = Color(0xFF879498)
            )
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    Card()
}