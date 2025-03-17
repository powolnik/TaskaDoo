package com.main.taskadoo_app.navigation

sealed class Screen(val route: String){
    data object Home: Screen(route = "home_screen")
    data object Note: Screen(route = "note_screen")
    data object Settings: Screen(route = "settings_screen")
    data object NotesList: Screen(route = "notes-list_screen")
}