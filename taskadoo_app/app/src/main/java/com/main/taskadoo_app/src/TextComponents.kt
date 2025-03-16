package com.main.taskadoo_app.src

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.main.taskadoo_app.ui.theme.Typography

//region Text Components
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
fun TDTextField(
	value: String,
	onValueChange: (String) -> Unit,
	placeholder: String = "DEFAULT...",
	modifier: Modifier = Modifier,
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
fun TDText(modifier: Modifier = Modifier.fillMaxWidth(),
		   text: String,
		   textStyle: TextStyle = Typography.displaySmall,
		   maxLines: Int = 3,
		   overflow: TextOverflow = TextOverflow.Ellipsis,
		   textColor: Color = MaterialTheme.colorScheme.onPrimary,
		   textBackground: Color = MaterialTheme.colorScheme.primary,
		   paddingValues: Int = 10,
) {
	Text(
		text = text,
		modifier = modifier
			.padding(paddingValues.dp)
			.background(color = textBackground, shape = RectangleShape),
		style = textStyle.copy(color = textColor),
		maxLines = maxLines,
		overflow = overflow
	)
}
//endregion
