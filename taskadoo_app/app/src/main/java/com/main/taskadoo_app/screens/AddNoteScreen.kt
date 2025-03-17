package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import com.main.taskadoo_app.src.TDColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.main.taskadoo_app.Screen
import com.main.taskadoo_app.src.TDButton
import com.main.taskadoo_app.src.TDRow
import com.main.taskadoo_app.src.TDTextField



@Composable
fun AddNoteScreen(navController: NavController
) {
    var TitleText by remember { mutableStateOf("") }
    var ContentText by remember { mutableStateOf("") }
    TDRow(modifier = Modifier.fillMaxSize()) {
        TDColumn(arrangement = Arrangement.Top) {
            TDTextField(
                value = TitleText,
                onValueChange = { TitleText = it },
                placeholder = "Enter note title...",
            )
            TDTextField(
                value = ContentText,
                onValueChange = { ContentText = it },
                placeholder = "Enter note content..."
            )
            TDButton("Save Note",
                onClickAction = {
                    navController.navigate(route = Screen.Home.route)
                })
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AddingNoteScreenPreview(){
//    AddNoteScreen()
//}
