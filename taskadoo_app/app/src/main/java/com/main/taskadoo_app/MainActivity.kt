package com.main.taskadoo_app

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.ui.text.withStyle
import com.main.taskadoo_app.ui.theme.ComposeTestTheme

//region MainActivity
    // Main activity class that sets up the application content
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                ComposeTestTheme {
                    FColumnsPreview()
                }
            }
        }
    }
//endregion

//region Composable
    // Composable function that displays styled text
    @Composable
    fun FText(color: Color = MaterialTheme.colorScheme.error, inputText: String = "Default") {
        if (inputText.isEmpty()) {
            // Error handling for empty input text
            throw IllegalArgumentException("Input text cannot be empty")
        }
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(textAlign = TextAlign.Center,)) {
                    withStyle(style = SpanStyle(
                        color = color,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold)
                    ) {
                        append("$inputText")
                    }
                }
            }
        )
    }

    //uses FText to display a title
    // Composable function that creates a button within the column scope
    @Composable
    fun FButton(text: String = "DEFAULT") {
        if (text.isEmpty()) {
            // Error handling for empty button text
            throw IllegalArgumentException("Button text cannot be empty")
        }
        FText(MaterialTheme.colorScheme.onPrimary, text)
    }

    // FColumns uses FSurface to create a surface within a column scope
    // Composable function that creates a column layout with two surfaces
    @Composable
    fun FColumns() {
        // Remove unnecessary variable assignment
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(500.dp) // Removed redundant height assignment
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            FSurface(MaterialTheme.colorScheme.primary)
            FSurface(MaterialTheme.colorScheme.primary)
        }
    }

    // FSurface uses FButton to create a button within a surface scope
    // Composable function that creates a surface within a column scope
    @Composable
    fun ColumnScope.FSurface(color: Color, weight: Float = 1f) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(weight)
                .wrapContentHeight(Alignment.CenterVertically),
            color = color
        ) {
            FButton("Button")
        }
    }
//endregion

//region Composable Preview
    // Preview composable function that displays the FColumns composable
    @Preview(showBackground = true)
    @Composable
    fun FColumnsPreview() {
        ComposeTestTheme {
            FColumns()
        }
    }
//endregion