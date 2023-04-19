package com.adriana.listadetarefascompose.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TaskList(
    navController: NavController
){
    Text(text = "Lista de Tarefas")
}