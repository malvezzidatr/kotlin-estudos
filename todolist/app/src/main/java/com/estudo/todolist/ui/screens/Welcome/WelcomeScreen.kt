package com.estudo.todolist.ui.screens.Welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estudo.todolist.ui.components.CategoryPill
import com.estudo.todolist.ui.components.CornerArcs

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFFFF5EB)),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            ) {
                CornerArcs(
                    modifier = Modifier
                        .align(Alignment.TopStart),
                    lineCount = 8,
                )
                CategoryPill(
                    text = "Planning",
                    color = Color(0xFFB8E8FF),
                    rotationDegrees = 70f,
                    modifier = Modifier.offset(x = 150.dp, y = 5.dp)
                )
                CategoryPill(
                    text = "Writing",
                    color = Color(0xFFFFCFA8),
                    rotationDegrees = 25f,
                    modifier = Modifier.offset(x = 50.dp, y = 90.dp)
                )
                CategoryPill(
                    text = "Running",
                    color = Color(0xFFE0C8FF),
                    rotationDegrees = 40f,
                    modifier = Modifier.offset(x = 260.dp, y = 85.dp)
                )
                CategoryPill(
                    text = "Meeting",
                    color = Color(0xFFCFF5D8),
                    rotationDegrees = -25f,
                    modifier = Modifier.offset(x = 150.dp, y = 170.dp)
                )
                CategoryPill(
                    text = "Cooking",
                    color = Color(0xFFFFCFCF),
                    rotationDegrees = -5f,
                    modifier = Modifier.offset(x = 30.dp, y = 250.dp)
                )
                CategoryPill(
                    text = "Shopping",
                    color = Color(0xFFB8F0F0),
                    rotationDegrees = 15f,
                    modifier = Modifier.offset(x = 250.dp, y = 260.dp)
                )
                CategoryPill(
                    text = "Study",
                    color = Color.Yellow,
                    rotationDegrees = 65f,
                    modifier = Modifier.offset(x = 175.dp, y = 310.dp)
                )
                CategoryPill(
                    text = "Read",
                    color = Color.Cyan,
                    rotationDegrees = -150f,
                    modifier = Modifier.offset(x = 80.dp, y = 390.dp)
                )
                CategoryPill(
                    text = "Cleaning",
                    color = Color.Magenta,
                    rotationDegrees = 80f,
                    modifier = Modifier.offset(x = 170.dp, y = 460.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .background(Color.White)
                    .padding(top = 24.dp)
                    .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Easily organize your day-to-day activities",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    "This intuitive tool is crafted to help you effortlessly manage your daily tasks",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF444348),
                    lineHeight = 32.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF070127)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    Text(
                        "Explore now",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}