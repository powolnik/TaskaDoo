package com.main.taskadoo_app

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.main.taskadoo_app.src.Note
import com.main.taskadoo_app.src.NoteItem
import com.main.taskadoo_app.src.NotesListComposable
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
                //NotesListComposable(notes = listOf(Note("Note 1", "This is note 1"), Note("Note 2", "This is note 2")))
                }
            }
        }
    }
//endregion

/*//region Composable
    // Composable function that displays styled text
    @Composable
    fun FText(color: Color = MaterialTheme.colorScheme.error, inputText: String = "DEFAULT") {
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

    // FButton uses FText to display a title
    // Composable function that creates a button within the column scope
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
            FSurface(MaterialTheme.colorScheme.primaryContainer)
            FSurface(MaterialTheme.colorScheme.surfaceVariant)
            //for
        }
    }

    // FSurface uses FButton to create a button within a surface scope
    // Composable function that creates a surface within a column scope
    @Composable
    fun ColumnScope.FSurface(color: Color = MaterialTheme.colorScheme.primary, weight: Float = 1f) {
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
    @Composable
    fun FButton(text: String = "DEFAULT EXCEPTIION TEXT") {
        if (text.isEmpty()) {
            // Error handling for empty button text
            throw IllegalArgumentException("Button text cannot be empty")
        }
        FText(MaterialTheme.colorScheme.onPrimary, text)
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
//endregion*/
