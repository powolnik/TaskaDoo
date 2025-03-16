package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.main.taskadoo_app.src.TDNote
import com.main.taskadoo_app.components.TDButton
import com.main.taskadoo_app.components.TDColumn
import com.main.taskadoo_app.components.TDRow
import com.main.taskadoo_app.src.TDNoteCard


/*** Composable screen for displaying a note.
 *
 * This screen presents a note with a title and content inside a card layout.
 * Additionally, it includes a button to display the note content as a toast message.
 *
 * @ navController The [NavController] used for navigation between screens.*/
@Composable
fun NoteScreen(/*navController: NavController*/) {
	TDColumn(modifier = Modifier.fillMaxSize(),
		arrangement = Arrangement.SpaceBetween
	) {
		// Looped it so i get longer text without messing up space here in code, temp, to be deleted
		var contentTEMP = ("s")
		for (i in 1..2){
			contentTEMP += ("Lorem ipsum rep num: $i...")
		}

		// Created sample note, inputing string prepared above
		val note = TDNote("id", "Title", contentTEMP)

		TDRow(horizontalArrangement = Arrangement.Center) {
			TDNoteCard(
				note, { println("From TDNoteCard") },
				onDeleteClick = {}
			)
		}


		// Toasting note content
		TDButton(name = "Toast",
			toast = note.content
		)
	}
}

@Preview(showBackground = true)
@Composable
fun NotePreviewScreenPreview(){
	NoteScreen()
}
