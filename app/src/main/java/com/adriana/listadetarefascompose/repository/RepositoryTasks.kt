package com.adriana.listadetarefascompose.repository

import com.adriana.listadetarefascompose.datasource.DataSource

class RepositoryTasks{

    private val dataSource = DataSource()

    fun saveTask(task: String, description: String, priority: Int){
        dataSource.saveTask(task,description,priority)

    }

}