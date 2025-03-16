package com.main.taskadoo_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.taskadoo_app.ui.theme.Typography
import androidx.compose.ui.graphics.Shape

/*** A composable text field component that wraps [TextField] with additional styling.
 *
 * This component is a customized text field that fills the width of its parent,
 * applies standard padding, and uses a specific text style from the app's typography.
 *
 * @param value The current text displayed in the text field.
 * @param onValueChange Callback that is triggered when the text changes.
 * @param placeholder A string to display as a placeholder when the text field is empty.
 * @param modifier A [Modifier] for this text field. Defaults to [Modifier] if not provided.
 * @param isSingleLine Determines whether the text field should be a single line.*/
@Composable
fun TDTextField(modifier: Modifier = Modifier,
	value: String = "TextField...",
	onValueChange: (String) -> Unit,
	placeholder: String = "DEFAULT...",
	isSingleLine: Boolean = true,
	paddingValues: Int = 10
) {
	TextField(
		value = value,
		onValueChange = onValueChange,
		placeholder = { Text(placeholder) },
		modifier = modifier
			.fillMaxWidth()
			.padding(paddingValues.dp),
		textStyle = Typography.displaySmall,
		singleLine = isSingleLine
	)
}

/*** A composable function for displaying styled text.
 *
 * @param text The text content.
 * @param modifier Customization modifier.
 * @param textColor The color of the text.
 * @param textBackground The background color of the text.
 * @param paddingValues Padding around the text.
 * @param textStyle The text style.*/
@Composable
fun TDText(
	modifier: Modifier = Modifier,
	text: String = "DEFAULT",
	textStyle: TextStyle = Typography.displaySmall,
	maxLines: Int = 3,
	overflow: TextOverflow = TextOverflow.Ellipsis,
	textColor: Color = MaterialTheme.colorScheme.onBackground,
	textBackground: Color = MaterialTheme.colorScheme.background,
	paddingValues: Int = 10,
	horizontal: TextAlign = TextAlign.Center,
	// New parameter with default value
	shape: Shape = RectangleShape, 
) {
	Text(modifier = modifier
		.padding(paddingValues.dp)
		.background(color = textBackground, shape = shape),
		text = text,
		style = textStyle.copy(color = textColor),
		maxLines = maxLines,
		overflow = overflow,
		textAlign = horizontal
	)
}

/*** A composable function that represents a search bar.
 *
 * This search bar allows users to input a query, with a search icon as the leading element.
 *
 * @param searchQuery The current search query entered by the user.
 * @param onSearchQueryChange A lambda function that updates the search query.*/
@Composable
fun TDSearchBar(
	searchQuery: String,
	onSearchQueryChange: (String) -> Unit,
	// New parameter with default value
	placeholderText: String = "Search notes..." 
) {
	OutlinedTextField(
		value = searchQuery,
		onValueChange = onSearchQueryChange,
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp),
		placeholder = { Text(placeholderText) },
		leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
		singleLine = true,
		shape = RoundedCornerShape(24.dp)
	)
}

@Preview(showBackground = true)
@Composable
fun aa() {
	var t by remember { mutableStateOf("") }
	TDRow {
		TDTextField( value = "value",
			onValueChange = { t = it },
			placeholder = "Enter note content...")
	}
}
