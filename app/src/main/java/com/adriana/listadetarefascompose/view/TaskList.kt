package com.adriana.listadetarefascompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adriana.listadetarefascompose.R
import com.adriana.listadetarefascompose.itemlist.TaskItem
import com.adriana.listadetarefascompose.repository.RepositoryTasks
import com.adriana.listadetarefascompose.ui.theme.Purple200
import com.adriana.listadetarefascompose.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskList(
    navController: NavController
){
    val taskRepository = RepositoryTasks()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple200,
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE

                    )
                }
            )
        },
        backgroundColor = WHITE,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                     navController.navigate("saveList")

                },
                backgroundColor = Purple200
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Ícone de Salvar Tarefas!"
                )
            }
        }
        ) {

        val listTasks = taskRepository.recoverTask().collectAsState(mutableListOf()).value

        LazyColumn{
            itemsIndexed(listTasks) { position, _, ->
                TaskItem(
                    position = position,
                    listTasks = listTasks,
                    context = context,
                    navController = navController)
            }
        }
    }
}
