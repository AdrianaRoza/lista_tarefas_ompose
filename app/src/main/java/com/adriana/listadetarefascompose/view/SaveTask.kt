package com.adriana.listadetarefascompose.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adriana.listadetarefascompose.constant.Constant
import com.adriana.listadetarefascompose.components.TextBox
import com.adriana.listadetarefascompose.repository.RepositoryTasks
import com.adriana.listadetarefascompose.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveList(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repositoryTasks = RepositoryTasks()

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

        var taskTitle by remember {
            mutableStateOf("")
        }

        var taskDescription by remember {
            mutableStateOf("")
        }

        var noTaskPriority by remember {
            mutableStateOf(false)
        }

        var lowTaskPriority by remember {
            mutableStateOf(false)
        }

        var mediumTaskPriority by remember {
            mutableStateOf(false)
        }

        var highTasKPriority by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TextBox(
                value = taskTitle,
                onValueChange = {
                    taskTitle = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

                TextBox(
                    value =  taskDescription,
                    onValueChange = {
                        taskDescription = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(20.dp, 10.dp, 20.dp, 0.dp),
                    label = " Descrição",
                    maxLines = 10,
                    keyboardType = KeyboardType.Text
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(text = "Nível de Prioridade")

                    RadioButton(selected = lowTaskPriority ,
                        onClick = {
                            lowTaskPriority = !lowTaskPriority
                        },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = RADIO_BUTTON_GREEN_DISABLED,
                            selectedColor = RADIO_BUTTON_GREEN_SELECTED
                        )
                    )

                    RadioButton(selected = mediumTaskPriority ,
                        onClick = {
                            mediumTaskPriority = !mediumTaskPriority
                        },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = RADIO_BUTTON_YELLOW_DISABLED,
                            selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                        )
                    )

                    RadioButton(selected = highTasKPriority ,
                        onClick = {
                            highTasKPriority = !highTasKPriority
                        },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = RADIO_BUTTON_RED_DISABLED,
                            selectedColor = RADIO_BUTTON_RED_SELECTED
                        )
                    )

                }

            com.adriana.listadetarefascompose.components.Button(
                onclick = {

                    var message = true

                    scope.launch (Dispatchers.IO) {
                        if (taskTitle.isEmpty()){
                            message =false
                        }else if (taskTitle.isNotEmpty() && taskDescription.isNotEmpty() && lowTaskPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription, Constant.PRIORIDADE_BAIXA)
                            message = true
                        } else if (taskTitle.isNotEmpty() && taskDescription.isNotEmpty() && mediumTaskPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription, Constant.PRIORIDADE_MEDIA)
                            message = true
                        }else if (taskTitle.isNotEmpty() && taskDescription.isNotEmpty() && highTasKPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription, Constant.PRIORIDADE_ALTA)
                            message = true
                        }else if (taskTitle.isNotEmpty() && taskDescription.isNotEmpty() && noTaskPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription, Constant.SEM_PRIORIDADE)
                            message = true
                        }else if (taskTitle.isNotEmpty() && lowTaskPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription,Constant.PRIORIDADE_BAIXA)
                            message = true
                        }else if (taskTitle.isNotEmpty() &&mediumTaskPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription,Constant.PRIORIDADE_MEDIA)
                            message = true
                        }else if (taskTitle.isNotEmpty() && highTasKPriority){
                            repositoryTasks.saveTask(taskTitle, taskDescription,Constant.PRIORIDADE_ALTA)
                            message = true
                        }else{
                            repositoryTasks.saveTask(taskTitle, taskDescription,Constant.SEM_PRIORIDADE)
                            message = true
                        }
                    }

                    scope.launch (Dispatchers.Main){
                        if (message){
                            Toast.makeText(context, "Sucesso ao salvar a tarefa!",Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }else{
                            Toast.makeText(context, "Título da tarefa obrigatório",Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                text = "Salvar"
            )

            }

        }
    }

