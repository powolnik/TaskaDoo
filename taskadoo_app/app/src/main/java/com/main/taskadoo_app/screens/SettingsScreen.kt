package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.main.taskadoo_app.Screen
import com.main.taskadoo_app.src.TDBox
import com.main.taskadoo_app.src.TDButton


@Composable
fun SettingsScreen(navController: NavController) {
	TDBox(Modifier.fillMaxSize()
	) {
		TDButton("Settings",
			onClickAction = { navController.navigate(route = Screen.Home.route) })
	}
}
