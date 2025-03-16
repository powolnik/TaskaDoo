package com.main.taskadoo_app.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun BottomAppBar(
    navController: NavController, // Removed default rememberNavController()
    onAddNoteClick: () -> Unit = {navController.navigate(route = Screen.NotesList.route)},
    onSettingsClick: () -> Unit = {navController.navigate(route = Screen.Settings.route)},
    modifier: Modifier = Modifier,
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        IconButton(onClick = { onAddNoteClick() }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.Red/*MaterialTheme.colorScheme.onSurfaceVariant*/)
        }
        IconButton(onClick = { onSettingsClick() }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = null,
                tint = Color.Red/*MaterialTheme.colorScheme.onSurfaceVariant*/)
        }

    }
}
