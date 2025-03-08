package com.main.taskadoo_app.src

import android.service.autofill.OnClickAction
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TDButton(
    name: String = "DEFAULT",
    onClickAction: (() -> Unit)? = null,
    container_color: Color = MaterialTheme.colorScheme.secondary,
    content_color: Color = MaterialTheme.colorScheme.background
) {
    val ctx = LocalContext.current
    Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = container_color,
            contentColor = content_color
        ),
        onClick = {
            if (onClickAction == null) {
                Toast.makeText(ctx, "Default", Toast.LENGTH_SHORT).show()
                onClickAction?.invoke()
            }
            else {
                onClickAction()
            }
        }
    ) {
        TDText(name, content_color, container_color)
    }
}

@Composable
fun TDText(
    text: String,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.DarkGray,
    fontSize: TextUnit = 28.sp
) {
    Text(
        text = text,
        modifier = Modifier
            .padding(2.dp)
            .background(
                shape = RectangleShape,
                color = backgroundColor
            ),
        color = textColor,
        fontSize = fontSize
    )
}

@Composable
fun TDRow(row_count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {

        for (i in 1..row_count) {
            TDButton(onClickAction = {
                println("from row")
            })
        }
    }
}

@Composable
fun CxR(row_count: Int = 1, column_count: Int = 1) {
    for (i in 1..row_count) {
        Column() {
            for (i in 1..row_count) {
                TDRow(column_count)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {

    CxR(3, 4)
}

//@Preview()
//@Composable
//fun Preview() {
////    TDText("s")
//    TDButton()
//}

//@Composable
//fun TDColumn(){
//    Column(modifier = Modifier
////        .weight(1f)
//        .padding(end = 8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun TDColumnPreview(){
//    TDColumn()
//}