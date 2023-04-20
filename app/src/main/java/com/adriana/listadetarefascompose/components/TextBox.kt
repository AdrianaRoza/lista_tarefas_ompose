package com.adriana.listadetarefascompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adriana.listadetarefascompose.ui.theme.BLACK
import com.adriana.listadetarefascompose.ui.theme.LIGHT_BLUE
import com.adriana.listadetarefascompose.ui.theme.WHITE

@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String
){

    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = BLACK,
            focusedBorderColor = LIGHT_BLUE,
            focusedLabelColor = LIGHT_BLUE,
            backgroundColor = WHITE,
            cursorColor = LIGHT_BLUE
        )
    )
}

@Composable
@Preview
private fun TextBoxPreview(){
    TextBox(
        value = "Adriana",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Descrição"
    )
}