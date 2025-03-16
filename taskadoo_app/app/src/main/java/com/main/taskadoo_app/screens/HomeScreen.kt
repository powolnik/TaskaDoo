package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.Screen
import com.main.taskadoo_app.src.TDButton
import com.main.taskadoo_app.src.TDColumn
import com.main.taskadoo_app.src.TDRow


@Composable
fun HomeScreen(navController: NavController) {
    TDColumn(modifier = Modifier.fillMaxSize()) {
        TDRow(){
            TDButton(
                "AddNote",
                onClickAction = {
                    navController.navigate(route = Screen.AddNote.route)
                })
            TDButton(
                "Settings",
                onClickAction = {
                    navController.navigate(route = Screen.Settings.route)
                })
            TDButton(
                "Notes",
                onClickAction = {
                    navController.navigate(route = Screen.NotesList.route)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}