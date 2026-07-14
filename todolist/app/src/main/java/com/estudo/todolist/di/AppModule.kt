package com.estudo.todolist.di

import com.estudo.todolist.data.TaskDatabase
import com.estudo.todolist.data.TaskRepository
import com.estudo.todolist.ui.screens.TaskDetails.TaskDetailViewModel
import com.estudo.todolist.ui.screens.Home.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        TaskDatabase.getDatabase(androidContext())
    }

    single {
        TaskRepository(get<TaskDatabase>().taskDao())
    }

    viewModel {
        TaskViewModel(get())
    }

    viewModel {
        TaskDetailViewModel(get(), get())
    }
}