package com.adriana.listadetarefascompose.repository

import com.adriana.listadetarefascompose.datasource.DataSource
import com.adriana.listadetarefascompose.model.Task
import kotlinx.coroutines.flow.Flow

class RepositoryTasks{

    private val dataSource = DataSource()

    fun saveTask(task: String, description: String, priority: Int){
        dataSource.saveTask(task,description,priority)}

    fun recoverTask():Flow<MutableList<Task>>{
        return dataSource.recoverTasks()

    }

}