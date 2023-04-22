package com.adriana.listadetarefascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adriana.listadetarefascompose.ui.theme.ListaDeTarefasComposeTheme
import com.adriana.listadetarefascompose.view.SaveList
import com.adriana.listadetarefascompose.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTarefasComposeTheme {

                val navController = rememberNavController()
                
                NavHost(navController = navController, startDestination = "taskList"){
                    composable(
                        route = "taskList"
                    ){
                        TaskList(navController)
                    }

                    composable(
                        route = "saveList"
                    ){
                        SaveList(navController)
                    }
                }

            }
        }
    }
}



