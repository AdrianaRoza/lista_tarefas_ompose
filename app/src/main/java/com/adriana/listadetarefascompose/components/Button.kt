package com.adriana.listadetarefascompose.components

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adriana.listadetarefascompose.ui.theme.Purple200
import com.adriana.listadetarefascompose.ui.theme.WHITE

@Composable
fun Button (
    onclick: () -> Unit,
    modifier: Modifier,
    text: String,
){
    androidx.compose.material.Button(
        onclick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple200,
            contentColor = WHITE
        )
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}