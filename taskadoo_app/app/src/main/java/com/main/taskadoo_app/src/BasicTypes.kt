package com.main.taskadoo_app.src

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        TDText(name, content_color, container_color)
    }
}

@Composable
fun TDText(text: String,
           textColor: Color = Color.White,
           backgroundColor: Color = Color.DarkGray,
           fontSize: TextUnit = 28.sp)
{
    Text(text = text,
        modifier = Modifier
            .padding(2.dp)
            .background(shape = RectangleShape,
                color = backgroundColor),
        color = textColor,
        fontSize = fontSize)
}

@Preview()
@Composable
fun Preview() {
//    TDText("s")
    TDButton()
}





/*
@Composable
fun TDColumn(){
    Column(modifier = Modifier
        */
/*.weight(1f)*//*

        .padding(end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TDButton()
        TDButton()
    }
}

@Preview(showBackground = true)
@Composable
fun TDColumnPreview(){
    TDColumn()
}

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
*/