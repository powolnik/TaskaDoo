package com.main.taskadoo_app.dataBase

import android.icu.text.CaseMap

sealed interface NotesEvent {
    object SortNotes: NotesEvent

    data class DeleteNote(val note: Note): NotesEvent
    data class SaveNote(
        val title: String,
        val description: String
    ): NotesEvent
}