package com.main.taskadoo_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.main.taskadoo_app.screens.AddNoteScreen
import com.main.taskadoo_app.screens.HomeScreen
import com.main.taskadoo_app.screens.NoteScreen
import com.main.taskadoo_app.screens.NotesListScreen
import com.main.taskadoo_app.screens.SettingsScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(route = Screen.AddNote.route
        ) {
            AddNoteScreen(navController)
        }
        composable(route = Screen.Settings.route
        ) {
            SettingsScreen(navController)
        }
        composable(route = Screen.NotePreview.route
        ) {
            NoteScreen(navController)
        }
        composable(route = Screen.NotesList.route
        ) {
            NotesListScreen(navController)
        }
    }
}