package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TDButton(name: String = "DEFAULT",
           container_color: Color = MaterialTheme.colorScheme.primary,
           content_color: Color = MaterialTheme.colorScheme.background) {
    Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = container_color,
            contentColor = content_color),
        onClick = {

        }
    ) {
        Text(name)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TDButtonPreview() {
//    TDButton(name = "BlaBla", container_color = Color.Black, content_color = Color.Cyan)
//}

@Composable
fun TDColumn(){
    Column(modifier = Modifier
        /*.weight(1f)*/
        .padding(end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TDButton()
        TDButton()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TDColumnPreview(){
//    TDColumn()
//}

@Composable
fun TDRow(row_count: Int){
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        for (i in 1..row_count) {
            TDButton(name = "$i")
        }
    }
}

@Composable
fun CxR(column_count: Int = 1, row_count: Int = 1){
    for (i in 1..column_count){
        Column() {
            for (i in 1..column_count) {
                TDRow(row_count)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview(){
    CxR(2, 1)
}

