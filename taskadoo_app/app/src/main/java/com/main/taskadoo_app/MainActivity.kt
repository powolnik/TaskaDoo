package com.main.taskadoo_app

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.main.taskadoo_app.ui.theme.ComposeTheme


// Main activity class that sets up the application content
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                MainApp()
            }
        }
    }
}

