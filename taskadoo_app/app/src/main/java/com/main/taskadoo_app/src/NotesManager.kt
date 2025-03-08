package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotesManager() {
    var notes by remember { mutableStateOf(listOf<Note>()) }
    var newNoteTitle by remember { mutableStateOf("") }
    Column {
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                if (newNoteTitle.isNotBlank()) {
                    val newNote = Note(newNoteTitle, "")
                    notes = notes + newNote
                    newNoteTitle = "NNT"
                }
            }
        ) {
            Text("XD")
        }
        notes.forEachIndexed { index, note ->
            Text("Note $index: ${note.title}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesManagerPreview() {
    NotesManager()
}
