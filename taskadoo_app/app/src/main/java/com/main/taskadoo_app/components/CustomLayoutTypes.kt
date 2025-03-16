package com.main.taskadoo_app.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.main.taskadoo_app.src.TDNote
import com.main.taskadoo_app.src.TDNoteCard


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
             containerColor: Color = MaterialTheme.colorScheme.background,
             contentColor: Color = MaterialTheme.colorScheme.onBackground) {
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

/*** A composable function that creates a Box layout.
 *
 * @param modifier Customization modifier.
 * @param contentAlignment Alignment of content inside the Box.
 * @param content The composable content inside the Box.*/
@Composable
fun TDBox(modifier: Modifier = Modifier,
          contentAlignment: Alignment = Alignment.Center,
          content: @Composable BoxScope.() -> Unit = {}
) {
    Box(modifier = modifier,
        contentAlignment = contentAlignment,
        content = content
    )
}

/*** A composable function that arranges its children vertically in a column layout.
 *
 * This function wraps the standard [Column] composable to apply default styling,
 * including filling the available size and adding padding. The children are arranged
 * from the bottom of the available space and centered horizontally.
 *
 * @param modifier A [Modifier] for this layout that can be used to further customize the appearance.
 *                 Defaults to [Modifier].
 * @param contentPadding Padding values for the column's content area.
 * @param arrangement The vertical arrangement strategy for the children. Defaults to
 *                    [Arrangement.Bottom].
 * @param alignment The horizontal alignment strategy for the children. Defaults to
 *                  [Alignment.CenterHorizontally].
 * @param content A composable lambda that defines the content of the column.*/
@Composable
fun TDColumn(modifier: Modifier = Modifier,
             contentPadding: PaddingValues = PaddingValues(16.dp),
             arrangement: Arrangement.Vertical = Arrangement.Bottom,
             alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
             content: @Composable ColumnScope.() -> Unit ) {
    Column(modifier = modifier
        .padding(contentPadding),
        verticalArrangement = arrangement,
        horizontalAlignment = alignment,
        content = content
    )
}

/*** Composable function for creating a horizontally arranged row with predefined styling.
 *
 * This component provides:
 * - Full width occupation
 * - 16dp horizontal padding
 * - Items distributed with [Arrangement.SpaceBetween]
 *
 * @param content The content to be placed in the row, conforming to [RowScope].*/
@Composable
fun TDRow(
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        content = content
    )
}

/*** A composable function that adds a spacer for layout spacing.
 *
 * @param horizontal If true, applies width spacing; otherwise, applies height spacing.
 * @param size The predefined size of the spacer.*/
@Composable
fun TDSpacer(
    horizontal: Boolean = false,
    size: SpacerSize = SpacerSize.Medium
) {
    if (horizontal) {
        Spacer(modifier = Modifier.width(size.value))
    } else {
        Spacer(modifier = Modifier.height(size.value))
    }
}

/** Enum defining different spacer sizes. */
enum class SpacerSize(val value: Dp) {
    Medium(16.dp)
}

/*** A composable function that renders a card with predefined styling.
 *
 * @param content The composable content inside the card.*/
@Composable
fun TDCard(content: @Composable RowScope.() -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.secondary)
    ) {
        TDColumn(modifier = Modifier.padding(16.dp)
        ) {
            TDRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}

/*** A composable function that displays a list of notes.
 *
 * If the list is empty, a message is shown prompting users to add new notes.
 * Otherwise, the notes are displayed in a scrollable column.
 *
 * @param tdNote A list (`List<TDNote>`) of [TDNote] objects to be displayed.
// * @param onNoteClick A lambda function triggered when a note is clicked.
// * @param onDeleteClick A lambda function triggered when a note's delete button is clicked.*/
@Composable
fun TDNotesList(
    tdNote: List<TDNote>,
    onNoteClick: (TDNote) -> Unit = {},
//    onDeleteClick: (TDNote) -> Unit = {}
) = if (tdNote.isEmpty()) {
    TDBox(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TDText(
            text = "No notes yet. Click + to add a new note.",
            textStyle = MaterialTheme.typography.bodyLarge,
            textColor = MaterialTheme.colorScheme.primary
        )
    }
} else {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(3) {
            TDNoteCard(
                tdNote = TDNote(),
                onClick = { println("onNoteClick(note)") },
                onDeleteClick = { println("onDeleteClick(note)") }
            )
        }
    }
}
