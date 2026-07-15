package com.estudo.todolist.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

sealed class Routes(val route: String) {
    object TaskList : Routes("task_list")

    object TaskDetail : Routes("task_detail/{taskId}") {
        fun createRoute(taskId: Int) = "task_detail/$taskId"
    }

    object AddTask : Routes("add_task")

    object Config : Routes("user_config")
}

data class BottomNavItem(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Routes.TaskList.route, Icons.Default.Home),
    BottomNavItem(Routes.AddTask.route, Icons.AutoMirrored.Filled.Assignment),
    BottomNavItem(Routes.Config.route, Icons.Default.Settings),
)