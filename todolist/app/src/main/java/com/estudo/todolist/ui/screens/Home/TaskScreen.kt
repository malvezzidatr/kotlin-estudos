    package com.estudo.todolist.ui.screens.Home

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.CircularProgressIndicator
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.estudo.todolist.data.Task
    import com.estudo.todolist.ui.components.TaskCard
    import com.estudo.todolist.ui.components.TaskCarousel
    import com.estudo.todolist.ui.components.TaskInputField
    import com.estudo.todolist.ui.components.TaskList

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TaskScreen(
        viewModel: TaskViewModel,
        onTaskClick: (Int) -> Unit
    ) {
        var newTask by remember { mutableStateOf("") }
        val uiState by viewModel.uiState.collectAsState()

        TaskScreenContent(
            uiState = uiState,
            newTask = newTask,
            onNewTaskChange = { newTask = it },
            onAddClick = {
                viewModel.addTask(newTask)
                newTask = ""
            },
            onToggleCompleted = { viewModel.toggleCompleted(it) },
            onRemove = { viewModel.removeTask(it) },
            onTaskClick = { onTaskClick(it.id) }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TaskScreenContent(
        uiState: TaskUiState,
        newTask: String,
        onNewTaskChange: (String) -> Unit,
        onAddClick: () -> Unit,
        onToggleCompleted: (Task) -> Unit,
        onRemove: (Task) -> Unit,
        onTaskClick: (Task) -> Unit,
    ) {

        Scaffold(
            topBar = { TopAppBar(title = { Text("My Tasks") }) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                TaskInputField(
                    newTask = newTask,
                    onValueChange = onNewTaskChange,
                    onAddClick = onAddClick
                )
                Spacer(modifier = Modifier.height(16.dp))
                

                when (uiState) {
                    is TaskUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is TaskUiState.Success -> {
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                fontSize = 16.sp,
                                text = "To-do",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                fontSize = 11.sp,
                                text = "See all"
                            )
                        }
                        Spacer(Modifier.height(16.dp))
                        TaskCarousel(uiState.tasks, null, Color(0xFFE6FFE0))
                        Spacer(Modifier.height(16.dp))
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                fontSize = 16.sp,
                                text = "In progress",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                fontSize = 11.sp,
                                text = "See all"
                            )
                        }
                        Spacer(Modifier.height(16.dp))
                        TaskCard(
                            category = "Client Work",
                            title = "Felix Website Design",
                            time = "till Friday 8.00 AM",
                            footerRight = "60%",
                            backgroundColor = Color(0xFFE6E1FF),
                            progress = 0.60f,
                            modifier = Modifier.width(230.dp)
                        )
                    }

                    is TaskUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Erro: ${uiState.message}")
                        }
                    }
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskScreenContentLoadingPreview() {
        TaskScreenContent(
            uiState = TaskUiState.Loading,
            newTask = "",
            onNewTaskChange = {},
            onAddClick = {},
            onToggleCompleted = {},
            onRemove = {},
            onTaskClick = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskScreenContentSuccessPreview() {
        val tasksFake = listOf(
            Task(
                id = 1,
                title = "Comprar leite",
                description = "Ir ao mercado e comprar leite integral",
                category = "Personal work",
                dueDate = System.currentTimeMillis(),
                progress = 0f,
                completed = false
            ),
            Task(
                id = 2,
                title = "Estudar Kotlin",
                description = "Revisar coroutines e Flow",
                category = "Office work",
                dueDate = System.currentTimeMillis(),
                progress = 1f,
                completed = true
            ),
            Task(
                id = 3,
                title = "Fazer exercício",
                description = "Treino de pernas na academia",
                category = "Client Work",
                dueDate = System.currentTimeMillis(),
                progress = 1f,
                completed = true
            ),
            Task(
                id = 4,
                title = "Felix Website Design",
                description = "Finalizar layout do site do cliente",
                category = "Client Work",
                dueDate = System.currentTimeMillis(),
                progress = 0.56f,
                completed = false
            )
        )

        TaskScreenContent(
            uiState = TaskUiState.Success(tasksFake),
            newTask = "",
            onNewTaskChange = {},
            onAddClick = {},
            onToggleCompleted = {},
            onRemove = {},
            onTaskClick = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskScreenContentErrorPreview() {
        TaskScreenContent(
            uiState = TaskUiState.Error("Não foi possível carregar as tarefas"),
            newTask = "",
            onNewTaskChange = {},
            onAddClick = {},
            onToggleCompleted = {},
            onRemove = {},
            onTaskClick = {}
        )
    }