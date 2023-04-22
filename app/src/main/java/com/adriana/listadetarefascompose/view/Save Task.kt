package com.adriana.listadetarefascompose.view

import android.annotation.SuppressLint
import android.app.ActivityManager.TaskDescription
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adriana.listadetarefascompose.components.TextBox
import com.adriana.listadetarefascompose.ui.theme.Purple200
import com.adriana.listadetarefascompose.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveList(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple200,
                title = {
                    Text(
                        text = "Salvar Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )


        }
    ) {

        var TaskTitle by remember {
            mutableStateOf("")
        }

        var TaskDescription by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TextBox(
                value = TaskTitle,
                onValueChange = {
                    TaskTitle = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

                TextBox(
                    value =  TaskDescription,
                    onValueChange = {
                        TaskDescription = it
                    },
                    modifier = Modifier
                        .fillMaxWidth().height(150.dp)
                        .padding(20.dp, 10.dp, 20.dp, 0.dp),
                    label = " Descrição",
                    maxLines = 10,
                    keyboardType = KeyboardType.Text
                )


            }

        }
    }

