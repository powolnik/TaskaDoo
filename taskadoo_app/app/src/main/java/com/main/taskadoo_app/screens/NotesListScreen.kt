package com.main.taskadoo_app.screens

import android.widget.Toast
import com.main.taskadoo_app.src.NotesViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.components.TDNotesList
import com.main.taskadoo_app.components.TDSearchBar
import com.main.taskadoo_app.navigation.Screen
import com.main.taskadoo_app.components.TDColumn
import com.main.taskadoo_app.src.TDNote


/*** A composable function representing the screen that displays a list of notes.
 *
 * This screen includes a search bar for filtering notes, a floating action button
 * to add new notes, and a top app bar with a search icon.
 *
 * @param navController The navigation controller for handling navigation between screens.
 * @param notesViewModel The ViewModel that manages the notes list and search functionality.*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(navController: NavController,
			   notesViewModel: NotesViewModel = viewModel()
) {
	val context = LocalContext.current
	val searchQuery = notesViewModel.searchQuery
	val filteredNotes = notesViewModel.filteredNotes

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("My Notes") },
				actions = {
					IconButton(onClick = { /* TODO: Implement settings */ }) {
						Icon(Icons.Default.Search, contentDescription = "Search")
					}
				}
			)
		},
		floatingActionButton = {
			FloatingActionButton(
				onClick = { navController.navigate(route = Screen.Note.route) },
			) {
				Icon(Icons.Default.Add, contentDescription = "Add Note")
			}
		}
	) { paddingValues ->
		TDColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
		) {
			TDSearchBar(
				searchQuery = searchQuery,
				onSearchQueryChange = { notesViewModel.updateSearchQuery(it) }
			)
			TDNotesList(
				tdNotesList = listOf(TDNote("id", "T", "C"), TDNote("id", "T", "C")),
				onNoteClick = { Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show() },
				onDeleteClick = { notesViewModel.deleteNote(it) }) /*navController.navigate(route = Screen.NotePreview.route)*/
			}
	}
}

@Preview(showBackground = true)
@Composable
fun NotesListPreview(){
	NotesListScreen(navController = rememberNavController())
}
//@Preview(showBackground = true)
//@Composable
//fun bu(){
//	TDButton("B")
//}