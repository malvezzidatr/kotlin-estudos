package com.estudo.todolist.ui.navigation

sealed class Routes(val route: String) {
    object TaskList : Routes("task_list")

    object TaskDetail : Routes("task_detail/{taskId}") {
        fun createRoute(taskId: Int) = "task_detail/$taskId"
    }
}