package com.main.taskadoo_app.src

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
fun Button() {
    var noteTitle by remember { mutableStateOf("Note Title") }

    Button(
        modifier = Modifier.padding(8.dp),
        onClick = {
            // Change the note title
            noteTitle = "New Note Title"
        }
    ) {
        Text("Click me")
    }
    Text(text = noteTitle)
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Button()
}
