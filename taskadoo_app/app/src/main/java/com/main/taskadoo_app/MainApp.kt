package com.main.taskadoo_app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.components.TDButton
import com.main.taskadoo_app.navigation.BottomAppBar
import com.main.taskadoo_app.navigation.SetupNavGraph

@Composable
fun MainApp() {
	val navController: NavHostController = rememberNavController()
	Scaffold(bottomBar = { BottomAppBar(navController)}
	) { paddingValues ->
		SetupNavGraph(navController = navController, padding = paddingValues)
	}
}