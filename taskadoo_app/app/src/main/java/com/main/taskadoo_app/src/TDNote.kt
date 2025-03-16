package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.main.taskadoo_app.components.TDColumn
import com.main.taskadoo_app.components.TDRow
import com.main.taskadoo_app.components.TDSpacer
import com.main.taskadoo_app.components.TDText
import java.util.Date
import java.util.UUID


/**
 * Data class representing a note with a title and content.
 */
data class TDNote(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "Default",
    val content: String = "Default",
    val createdDate: Date = Date(13),
    val color: Color = Color.Cyan
)

/**
 * ViewModel to manage a list of notes, including adding, deleting, and filtering notes.
 */
class NotesViewModel : ViewModel() {
    private val notesList = mutableStateListOf<TDNote>()
    private val tdNotes: List<TDNote> get() = notesList

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
     * @param tdNote The note to be added.
     */
    private fun addNote(tdNote: TDNote) {
        notesList.add(0, tdNote) // Add to beginning of list
    }

    /**
     * Deletes a note from the list.
     * @param tdNote The note to be removed.
     */
    fun deleteNote(tdNote: TDNote) {
        notesList.remove(tdNote)
    }

    /**
     * Populates the notes list with sample notes.
     */
    private fun addSampleNotes() {
        addNote(TDNote(
            title = "Shopping List",
            content = "• Milk\n• Eggs\n• Bread\n• Cheese",
        ))
        addNote(TDNote(
            title = "Meeting Notes",
            content = "Discussed project timeline and assigned tasks to team members.",
        ))
        addNote(TDNote(
            title = "Ideas for Weekend",
            content = "Go hiking at the national park\nVisit the new art exhibition\nTry that new restaurant downtown",
        ))
    }

    /**
     * Filters notes based on the search query.
     * @return A list of notes that match the query.
     */
    val filteredNotes get() = if (searchQuery.isBlank()) {
        tdNotes
    } else {
        tdNotes.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.content.contains(searchQuery, ignoreCase = true)
        }
    }
}

/*** Composable function for displaying a note card.
 * @param tdNote The note to display.
 * @param onClick Callback when the note card is clicked.
 * @param onDeleteClick Callback when the delete button is clicked.*/
@Composable
fun TDNoteCard(
    tdNote: TDNote,
    onClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        TDColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            TDRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TDText(
                    text = tdNote.title,
                    textStyle = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = { onDeleteClick() },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Delete Note",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            TDSpacer()

            TDText(
                text = tdNote.content,
                textStyle = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    TDNoteCard(
        TDNote("x", "Title", "contentTEMP"),
        onClick = {},
        onDeleteClick = {}
    )
}
