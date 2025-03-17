package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.main.taskadoo_app.components.TDColumn
import com.main.taskadoo_app.components.TDRow

@Composable
fun HomeScreen(navController: NavController) {
    TDColumn(modifier = Modifier.fillMaxSize(),
        alignment = Alignment.CenterHorizontally,
        arrangement = Arrangement.Center
    ) {
        TDRow { /*BottomAppBar(navController)*/ }
    }
}

