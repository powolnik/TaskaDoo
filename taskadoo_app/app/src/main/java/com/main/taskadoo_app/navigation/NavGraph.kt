@file:OptIn(ExperimentalMaterial3Api::class)

package com.main.taskadoo_app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.screens.AddNoteScreen
import com.main.taskadoo_app.screens.HomeScreen
import com.main.taskadoo_app.screens.NoteScreen
import com.main.taskadoo_app.screens.NotesListScreen
import com.main.taskadoo_app.screens.SettingsScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TaskAdoo") },
                navigationIcon = {},
                actions = {}
            )
        }
    ) { innerPadding ->
        NavHost( // Ensure this uses androidx.navigation.compose.NavHost
            modifier = Modifier.padding(innerPadding),  // Apply padding via modifier
            navController = navController, 
            startDestination = Screen.Home.route
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(route = Screen.Note.route) {
                NoteScreen(/*navController*/)
            }
            composable(route = Screen.AddNote.route) {
                AddNoteScreen(navController)
            }
            composable(route = Screen.Settings.route) {
                SettingsScreen(navController)
            }
            composable(route = Screen.NotesList.route) {
                NotesListScreen(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun asd(){
    SetupNavGraph(rememberNavController())
}