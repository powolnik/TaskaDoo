package com.main.taskadoo_app

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.main.taskadoo_app.screens.AddNoteScreen
import com.main.taskadoo_app.screens.HomeScreen
import com.main.taskadoo_app.screens.NotePreviewScreen
import com.main.taskadoo_app.screens.SettingsScreen
import androidx.compose.foundation.lazy.items
import kotlin.collections.mutableListOf
import kotlin.collections.List

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    var xList = mutableListOf<kotlin.String>("s","1")
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
            NotePreviewScreen(navController)
        }
    }
}
