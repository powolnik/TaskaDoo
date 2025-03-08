package com.main.taskadoo_app

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.main.taskadoo_app.src.Note
import com.main.taskadoo_app.src.NoteItem
import com.main.taskadoo_app.src.text
import com.main.taskadoo_app.ui.theme.ComposeTestTheme

//region MainActivity
    // Main activity class that sets up the application content
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ComposeTestTheme {
                    NoteItem(note = Note("Title", text))
                }
            }
        }
    }
//endregion
