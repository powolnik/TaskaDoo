package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotesListComposable(notes: List<Note>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        notes.forEach { note ->
            NoteComposable(note = note)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesListComposablePreview(){
    NotesListComposable(notes = listOf(Note("Note 1", "This is note 1"), Note("Note 2", "This is note 2")))
}
