package com.main.taskadoo_app.dataBase

import android.icu.text.CaseMap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class NoteState(

    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf("")

    )