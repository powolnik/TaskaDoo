package com.main.taskadoo_app.src

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

data class Note(val title: String = "TITLE", val content: String = "CONTENT")


@Composable
fun NoteItem(
    note: Note
) {
    TDBox( content = {
        TDColumn()
        {
            TDText(note.title)
            TDRow{
                TDText(note.content)
            }
        }
    })
}

var text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
        "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit "

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    NoteItem(note = Note("Title",text))
}
