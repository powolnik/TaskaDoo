package com.main.taskadoo_app.src

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


data class Note(val title: String, val content: String)

@Composable
fun NoteItem(
    note: Note/*,
    onNoteClick: () -> Unit,
    onDeleteClick: () -> Unit*/
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable
            {

            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(note.title)
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center)
            {
                Text(note.content)
            }

        }
    }
}

var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    NoteItem(note = Note("Title",text))
}
