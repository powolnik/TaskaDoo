package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/*** A composable function that represents a search bar.
 *
 * This search bar allows users to input a query, with a search icon as the leading element.
 *
 * @param searchQuery The current search query entered by the user.
 * @param onSearchQueryChange A lambda function that updates the search query.*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TDSearchBar(
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit
) {
	OutlinedTextField(
		value = searchQuery,
		onValueChange = onSearchQueryChange,
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp),
		placeholder = { Text("Search notes...") },
		leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
		singleLine = true,
		shape = RoundedCornerShape(24.dp)
	)
}

/*** A composable function that displays a list of notes.
 *
 * If the list is empty, a message is shown prompting users to add new notes.
 * Otherwise, the notes are displayed in a scrollable column.
 *
 * @param notes A list of [Note] objects to be displayed.
 * @param onNoteClick A lambda function triggered when a note is clicked.
 * @param onDeleteClick A lambda function triggered when a note's delete button is clicked.*/
@Composable
fun TDNotesList(
	notes: List<Note>,
	onNoteClick: (Note) -> Unit,
	onDeleteClick: (Note) -> Unit
) {
	if (notes.isEmpty()) {
		TDBox(
			modifier = Modifier.fillMaxSize(),
			contentAlignment = Alignment.Center
		) {
			Text(
				text = "No notes yet. Click + to add a new note.",
				style = MaterialTheme.typography.bodyLarge,
				color = MaterialTheme.colorScheme.onSurfaceVariant
			)
		}
	} else {
		LazyColumn(
			modifier = Modifier.fillMaxSize(),
			contentPadding = PaddingValues(16.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(notes) { note ->
				TDNoteCard(
					note = note,
					onClick = { onNoteClick(note) },
					onDeleteClick = { onDeleteClick(note) }
				)
			}
		}
	}
}