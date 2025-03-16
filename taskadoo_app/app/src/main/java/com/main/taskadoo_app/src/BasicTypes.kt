package com.main.taskadoo_app.src


import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


/*** A composable function that renders a custom button.
 *
 * @param name The text displayed on the button.
 * @param toast The message displayed in a toast when clicked (if no action is provided).
 * @param onClickAction A lambda function executed when the button is clicked (optional).
 * @param containerColor The button's background color.
 * @param contentColor The button's text color.*/
@Composable
fun TDButton(name: String,
             toast: String = "Default",
             onClickAction: (() -> Unit)? = null,
             containerColor: Color = MaterialTheme.colorScheme.primary,
             contentColor: Color = MaterialTheme.colorScheme.onPrimary) {
    val ctx = LocalContext.current

    // Use a default action that shows a Toast if no action is provided.
    val effectiveOnClick = onClickAction ?: {
        Toast.makeText(ctx, toast, Toast.LENGTH_SHORT).show() }

    Button(modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor),
        onClick = effectiveOnClick)
    {
        TDText(modifier = Modifier, name)
    }
}