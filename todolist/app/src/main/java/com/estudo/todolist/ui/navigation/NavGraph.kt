package com.estudo.todolist.ui.navigation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.navigation.ModalBottomSheetLayout
import androidx.compose.material.navigation.bottomSheet
import androidx.compose.material.navigation.rememberBottomSheetNavigator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estudo.todolist.ui.screens.AddTaskSheet.AddTaskSheet
import com.estudo.todolist.ui.screens.AddTaskSheet.AddTaskSheetViewModel
import com.estudo.todolist.ui.screens.Home.TaskScreen
import com.estudo.todolist.ui.screens.Home.TaskViewModel
import com.estudo.todolist.ui.screens.TaskDetails.TaskDetailScreen
import com.estudo.todolist.ui.screens.TaskDetails.TaskDetailViewModel
import com.estudo.todolist.ui.screens.Welcome.WelcomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph() {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator
    ) {
        Scaffold(
            bottomBar = {
                BottomBarWithFab(
                    navController = navController,
                    onAddClick = {}
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Routes.TaskList.route,
                modifier = Modifier.padding(innerPadding)
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
                    Routes.TaskDetail.route,
                    arguments = listOf(navArgument("taskId") { type = NavType.IntType })
                ) {
                    val viewModel: TaskDetailViewModel = koinViewModel()
                    TaskDetailScreen(
                        viewModel = viewModel,
                        onNavigateBack = { navController.popBackStack() }
                    )
                }

                composable(
                    Routes.Welcome.route
                ) {
                    WelcomeScreen()
                }

                bottomSheet(Routes.AddTask.route, ) {
                    val viewModel: AddTaskSheetViewModel = koinViewModel()
                    AddTaskSheet (
                        onDismiss = { navController.popBackStack() },
                        viewModel = viewModel,
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBarWithFab(
    navController: NavController,
    onAddClick: () -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        NavigationBar(
            containerColor = Color.White,
            modifier = Modifier.height(70.dp)
        ) {
            bottomNavItems.take(1).forEach { item ->
                NavItem(item, currentRoute, navController)
            }

            Spacer(modifier = Modifier.weight(1f, fill = true))

            bottomNavItems.takeLast(1).forEach { item ->
                NavItem(item, currentRoute, navController)
            }
        }

        FloatingActionButton(
            onClick = { navController.navigate(Routes.AddTask.route) },
            shape = CircleShape,
            containerColor = Color.Black,
            contentColor = Color.White,
            modifier = Modifier
                .offset(y = (-20).dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Adicionar tarefa")
        }
    }
}

@Composable
private fun RowScope.NavItem(
    item: BottomNavItem,
    currentRoute: String?,
    navController: NavController
) {
    NavigationBarItem(
        selected = currentRoute == item.route,
        onClick = {
            navController.navigate(item.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        icon = { Icon(item.icon, contentDescription = item.route) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            unselectedIconColor = Color(0xFFAAAAAA),
            indicatorColor = Color.Transparent
        )
    )
}