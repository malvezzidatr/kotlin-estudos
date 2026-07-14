package com.estudo.todolist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estudo.todolist.ui.screens.Home.TaskScreen
import com.estudo.todolist.ui.screens.Home.TaskViewModel
import com.estudo.todolist.ui.screens.TaskDetails.TaskDetailScreen
import com.estudo.todolist.ui.screens.TaskDetails.TaskDetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.TaskList.route
    ) {
        composable(Routes.TaskList.route) {
            val viewModel: TaskViewModel = koinViewModel()
            TaskScreen(
                viewModel = viewModel,
                onTaskClick = { taskId ->
                    navController.navigate(Routes.TaskDetail.createRoute(taskId))
                }
            )
        }

        composable(
            route = Routes.TaskDetail.route,
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) {
            val viewModel: TaskDetailViewModel = koinViewModel()
            TaskDetailScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}