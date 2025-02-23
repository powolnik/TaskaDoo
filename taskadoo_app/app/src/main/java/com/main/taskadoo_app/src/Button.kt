package com.main.taskadoo_app.src

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Button() {
    Button(
        modifier = Modifier.padding(8.dp),
        onClick = {
            // Handle button click
        }
    ) {
        Text("Click me")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Button()
}
