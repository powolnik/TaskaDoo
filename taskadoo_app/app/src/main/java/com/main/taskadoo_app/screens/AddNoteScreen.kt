package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.fillMaxSize
import com.main.taskadoo_app.components.TDColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.navigation.Screen
import com.main.taskadoo_app.components.TDRow
import com.main.taskadoo_app.components.TDTextField
import com.main.taskadoo_app.components.TDButton


/*** Composable screen for adding a new note.
 *
 * This screen provides two input fields for the note's title and content,
 * as well as a button to save the note. Upon clicking the "Save Note" button,
 * the user is navigated back to the home screen.
 *
 * @param navController The [NavController] used for navigating between screens.*/
@Composable
fun AddNoteScreen(navController: NavController
) {
    var titleText by remember { mutableStateOf("") }
    var contentText by remember { mutableStateOf("") }
    TDColumn(modifier = Modifier.fillMaxSize()) {
        TDRow {
            TDTextField(
                value = titleText,
                onValueChange = { titleText = it },
                placeholder = "Enter note title...",
            )
        }
        TDRow {
            TDTextField(
                value = contentText,
                onValueChange = { contentText = it },
                placeholder = "Enter note content..."
            )
        }
        TDColumn {
            TDButton(name = "Save Note",
                onClickAction = {
                    println("AddNote OnClick")
                    navController.navigate(route = Screen.Home.route) } )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddNoteScreenPreview(){
    AddNoteScreen(navController = rememberNavController())
}