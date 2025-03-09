package com.main.taskadoo_app.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.main.taskadoo_app.src.TDButton
import com.main.taskadoo_app.src.TDColumn


@Composable
fun StartScreen(){
    TDColumn {
        TDButton("AddNote",
            onClickAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    StartScreen()
}