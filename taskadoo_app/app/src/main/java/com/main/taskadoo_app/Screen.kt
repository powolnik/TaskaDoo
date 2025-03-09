package com.main.taskadoo_app

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object AddNote: Screen(route = "add-note_screen")
    object Settings: Screen(route = "settings_screen")
}