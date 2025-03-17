package com.main.taskadoo_app.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.taskadoo_app.src.TDNote


/*** A composable function that renders a custom button.
 *
 * @param name The text displayed on the button.
 * @param toast The message displayed in a toast when clicked (if no action is provided).
 * @param onClickAction A lambda function executed when the button is clicked (optional).
 * @param containerColor The button's background color.
 * @param contentColor The button's text color.*/
@Composable
fun TDButton(name: String,
			 modifier: Modifier,
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


/*** Composable function for displaying a note card.
 * @param tdNote The note to display.
 * @param onClick Callback when the note card is clicked.
 * @param onDeleteClick Callback when the delete button is clicked.*/
@Composable
fun TDNoteCard(
	tdNote: TDNote,
	onClick: () -> Unit = {},
	onDeleteClick: () -> Unit = {}
) {
	TDCard(
		modifier = Modifier,
	) {
		TDColumn(
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp)
		) {
			TDRow(
				modifier = Modifier.weight(.2f),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {

				TDTextField(
					modifier = Modifier.weight(1f),
					value = "Title...",
					onValueChange = {},
					placeholder = "Default...",
					isSingleLine = true,
					paddingValues = PaddingValues(15.dp)
				)

				IconButton(
					onClick = { onDeleteClick() },
					modifier = Modifier
						.size(24.dp)
						.weight(.25f)
				) {
					Icon(
						Icons.Default.Delete,
						contentDescription = "Delete Note",
						tint = MaterialTheme.colorScheme.onSurface
					)
				}
			}

			TDSpacer()

			TDTextField(
				modifier = Modifier
					.weight(1f)
					.wrapContentSize()
					.fillMaxSize(),
				value = tdNote.content,
				onValueChange = { },
				placeholder = "Default...",
				isSingleLine = false,
				paddingValues = PaddingValues(15.dp)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TDNoteCardPrev(){
	TDNoteCard(
		tdNote = TDNote("X","Y","Z")
	)
}
