package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Data class representing a note with a title and content.
 */
data class Note(val title: String = "TITLE", val content: String = "CONTENT")
/*
data class Note(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String,
    val createdDate: Date = Date(),
    val color: Color = NoteColors.random()
)
*/

/**
 * ViewModel to manage a list of notes, including adding, deleting, and filtering notes.
 */
class NotesViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    var searchQuery by mutableStateOf("")
        private set

    init {
        // Initialize with sample notes
        addSampleNotes()
    }

    /**
     * Updates the search query for filtering notes.
     * @param query The search text input.*/
    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    /**
     * Adds a new note to the list.
     * @param note The note to be added.
     */
    fun addNote(note: Note) {
        _notes.add(0, note) // Add to beginning of list
    }

    /**
     * Deletes a note from the list.
     * @param note The note to be removed.
     */
    fun deleteNote(note: Note) {
        _notes.remove(note)
    }

    /**
     * Populates the notes list with sample notes.
     */
    private fun addSampleNotes() {
        addNote(Note(
            title = "Shopping List",
            content = "• Milk\n• Eggs\n• Bread\n• Cheese",
        ))
        addNote(Note(
            title = "Meeting Notes",
            content = "Discussed project timeline and assigned tasks to team members.",
        ))
        addNote(Note(
            title = "Ideas for Weekend",
            content = "Go hiking at the national park\nVisit the new art exhibition\nTry that new restaurant downtown",
        ))
    }

    /**
     * Filters notes based on the search query.
     * @return A list of notes that match the query.
     */
    val filteredNotes get() = if (searchQuery.isBlank()) {
        notes
    } else {
        notes.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.content.contains(searchQuery, ignoreCase = true)
        }
    }
}

/*** Composable function for displaying a note card.
 * @param note The note to display.
 * @param onClick Callback when the note card is clicked.
 * @param onDeleteClick Callback when the delete button is clicked.*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TDNoteCard(
    note: Note = Note("X", "Y"),
    onClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = onDeleteClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Delete Note",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            TDText(
                text = note.content,
                textStyle = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "test", // Placeholder for additional note details
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
//@Composable
//fun NoteItem(
//    note: Note
//) {
//    TDBox( content = {
//        TDColumn()
//        {
//            TDText(note.title)
//            TDRow{
//                TDText(note.content)
//            }
//        }
//    })
//}

var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
        "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit "

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    TDNoteCard( note = Note("Title", text),
		onClick = {},
		onDeleteClick = {})
}
