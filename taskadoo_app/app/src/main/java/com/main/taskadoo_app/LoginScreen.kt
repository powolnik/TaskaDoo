package com.main.taskadoo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.main.taskadoo_app.ui.theme.ComposeTestTheme

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
            }
        }
    }
}
