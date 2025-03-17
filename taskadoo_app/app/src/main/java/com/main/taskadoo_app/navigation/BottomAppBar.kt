package com.main.taskadoo_app.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.twotone.Create
import androidx.compose.material.icons.twotone.List
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BottomAppBar(
    navController: NavController, // Removed default rememberNavController()
    onNoteListClicked: () -> Unit = {navController.navigate(route = Screen.NotesList.route)},
    onSettingsClick: () -> Unit = {navController.navigate(route = Screen.Settings.route)},
    onNoteClicked: () -> Unit = {navController.navigate(route = Screen.Note.route)},
        modifier: Modifier = Modifier,
) {
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.Center) {
        IconButton(onClick = { onNoteListClicked() }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.List,
                contentDescription = null,
                tint = Color.Red/*MaterialTheme.colorScheme.onSurfaceVariant*/)
        }
        IconButton(onClick = { onNoteClicked() }) {
            Icon(imageVector = Icons.TwoTone.Create,
                contentDescription = null,
                tint = Color.Red/*MaterialTheme.colorScheme.onSurfaceVariant*/)
        }
        IconButton(onClick = { onSettingsClick() }) {
            Icon(imageVector = Icons.TwoTone.Settings,
                contentDescription = null,
                tint = Color.Red/*MaterialTheme.colorScheme.onSurfaceVariant*/)
        }

    }
}
