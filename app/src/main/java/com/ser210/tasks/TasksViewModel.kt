package com.ser210.tasks


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class TasksViewModel(val dao: TaskDao) : ViewModel() {
    var newTaskName = ""

    val tasks = dao.getAll()

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}