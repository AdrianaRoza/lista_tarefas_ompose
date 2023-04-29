package com.adriana.listadetarefascompose.datasource


import com.adriana.listadetarefascompose.model.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class DataSource {

    private val db = FirebaseFirestore.getInstance()

    private val _allTasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    private val allTasks: StateFlow<MutableList<Task>> = _allTasks

    fun saveTask(task: String, description: String, priority: Int){

        val taskMap = hashMapOf(
            "task" to  task,
            "description" to description,
            "priority" to priority
        )

        db.collection("task").document(task).set(taskMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    fun recoverTasks(): Flow<MutableList<Task>>{

        val listTask: MutableList<Task> = mutableListOf()

        db.collection("task").get().addOnCompleteListener {querySnapshot ->
            if (querySnapshot.isSuccessful){
                for (document in querySnapshot.result){
                    val task = document.toObject(Task::class.java)
                    listTask.add(task)
                    _allTasks.value = listTask
                }
            }
        }
        return allTasks
    }
}