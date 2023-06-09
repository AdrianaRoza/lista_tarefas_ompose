package com.adriana.listadetarefascompose.itemlist

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.adriana.listadetarefascompose.R
import com.adriana.listadetarefascompose.model.Task
import com.adriana.listadetarefascompose.repository.RepositoryTasks
import com.adriana.listadetarefascompose.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TaskItem(
    position: Int,
    listTasks: MutableList<Task>,
    context: Context,
    navController: NavController
){

    val titleTask = listTasks[position].task
    val descriptionTask = listTasks[position].description
    val priorityTask = listTasks[position].priority

    val scope = rememberCoroutineScope()
    val repositoryTasks= RepositoryTasks()

    fun dialogDelete(){
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar Tarefa")
            .setMessage("Deseja Excluir a Tarefa?")
            .setPositiveButton("Sim"){ _, _, ->
                repositoryTasks.deleteTask(titleTask.toString())

                scope.launch(Dispatchers.Main){
                    listTasks.removeAt(position)
                    navController.navigate("TaskList")
                    Toast.makeText(context,"Sucesso ao Deletar Tarefa!", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não"){ _, _, ->
            }
            .show()
    }

    var priorityLevel: String = when(priorityTask){
        0 -> {
            "Sem prioridade"
        }
        1 -> {
            "Prioridade Baixa"
        }
        2 -> {
            "Prioridade Média"
        }
        else -> {
            "Prioridade Alta"
        }
    }

    var color = when(priorityTask){
        0 -> {
            Color.Black
        }
        1 -> {
            RADIO_BUTTON_GREEN_SELECTED
        }
        2 ->{
            RADIO_BUTTON_YELLOW_SELECTED
        }
        else -> {
            RADIO_BUTTON_RED_SELECTED
        }
    }

    Card(
        backgroundColor = Purple,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            
            val (txtTitle,txtDescription,cardPriority,txtPriority,btDelete) = createRefs()

            Text(
                text = titleTask.toString(),
                modifier = Modifier.constrainAs(txtTitle){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }

            )

            Text(
                text = descriptionTask.toString(),
                modifier = Modifier.constrainAs(txtDescription){
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }

            )

            Text(
                text = priorityLevel,
                modifier = Modifier.constrainAs(txtPriority){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                backgroundColor = color,
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPriority) {
                        top.linkTo(txtDescription.bottom, margin = 10.dp)
                        start.linkTo(txtPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)

                    },
                shape = ShapeCardPriority.large
            ) {

            }
            IconButton(
                onClick = {
                    dialogDelete()

            },
                modifier = Modifier.constrainAs(btDelete){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(cardPriority.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)

            }
        }
    }
}

