package com.main.taskadoo_app.screens

import com.main.taskadoo_app.src.TDColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.main.taskadoo_app.src.TDTextField


/**
 * A composable screen that provides an interface for adding a note.
 *
 * This screen uses [TDColumn] to layout its content and includes a [TDTextField]
 * for note entry. The state of the text input is managed locally using Compose's state.
 */
@Composable
fun AddingNoteScreen() {
    var text by remember { mutableStateOf("") }

    TDColumn {
        TDTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = "Enter text..."
        )
    }
}
