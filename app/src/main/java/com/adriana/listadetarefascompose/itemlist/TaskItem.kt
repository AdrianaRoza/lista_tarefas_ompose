package com.adriana.listadetarefascompose.itemlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.adriana.listadetarefascompose.R
import com.adriana.listadetarefascompose.ui.theme.Purple
import com.adriana.listadetarefascompose.ui.theme.ShapeCardPriority

@Composable
fun TaskItem(){

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
                text = "Task 1",
                modifier = Modifier.constrainAs(txtTitle){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }

            )

            Text(
                text = "asgagsgasasasasasasagsaggahsgshg",
                modifier = Modifier.constrainAs(txtDescription){
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }

            )

            Text(
                text = "Prioridade Baixa",
                modifier = Modifier.constrainAs(txtPriority){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                backgroundColor = Color(0xFF318635),
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

