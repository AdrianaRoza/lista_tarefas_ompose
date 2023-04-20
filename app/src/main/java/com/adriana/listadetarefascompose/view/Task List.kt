package com.adriana.listadetarefascompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adriana.listadetarefascompose.R
import com.adriana.listadetarefascompose.ui.theme.BLACK
import com.adriana.listadetarefascompose.ui.theme.Purple200
import com.adriana.listadetarefascompose.ui.theme.Purple700
import com.adriana.listadetarefascompose.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskList(
    navController: NavController
){
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
        backgroundColor = BLACK,
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

    }
}