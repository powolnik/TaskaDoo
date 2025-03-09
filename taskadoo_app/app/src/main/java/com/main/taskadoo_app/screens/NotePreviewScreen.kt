package com.main.taskadoo_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.src.Note
import com.main.taskadoo_app.src.NoteItem
import com.main.taskadoo_app.src.TDButton
import com.main.taskadoo_app.src.TDColumn
import com.main.taskadoo_app.src.TDRow

@Composable
fun NotePreviewScreen(navController: NavController) {
	TDColumn(modifier = Modifier.fillMaxSize(),
		arrangement = Arrangement.Center)
	{
		var contentTEMP = ("s")
		for (i in 1..2){
			contentTEMP += ("Lorem ipsum rep num: $i...")
		}
		var note = Note("Title", contentTEMP)

		TDRow() {
			NoteItem(note)
		}
		TDButton("X", note.content
		)
	}
}

@Preview(showBackground = true)
@Composable
fun NotePreviewScreenPreview(){
	NotePreviewScreen(navController = rememberNavController())
}