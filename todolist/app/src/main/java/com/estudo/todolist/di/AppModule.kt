package com.estudo.todolist.di

import com.estudo.todolist.data.TaskDatabase
import com.estudo.todolist.data.TaskRepository
import com.estudo.todolist.ui.TaskViewModel
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
}