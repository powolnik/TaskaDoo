package com.main.taskadoo_app.src

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/*** A composable function that creates a Box layout.
 *
 * @param modifier Customization modifier.
 * @param contentAlignment Alignment of content inside the Box.
 * @param content The composable content inside the Box.*/
@Composable
fun TDBox(modifier: Modifier = Modifier,
		  contentAlignment: Alignment = Alignment.Center,
		  content: @Composable BoxScope.() -> Unit
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
 * @param content A composable lambda that defines the content of the column.*/
@Composable
fun TDColumn(modifier: Modifier = Modifier.fillMaxSize(),
			 contentPadding: PaddingValues = PaddingValues(16.dp),
			 arrangement: Arrangement.Vertical = Arrangement.Bottom,
			 alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
			 content: @Composable ColumnScope.() -> Unit ) {
	Column(modifier = modifier
		.padding(contentPadding),
		verticalArrangement = arrangement,
		horizontalAlignment = Alignment.CenterHorizontally,
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
	modifier: Modifier = Modifier.padding(16.dp),
	vertivalAlignment: Alignment.Vertical = Alignment.CenterVertically,
	horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
	content: @Composable RowScope.() -> Unit,) {
	Row(
		modifier = modifier,
		verticalAlignment = vertivalAlignment,
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
	ExtraSmall(4.dp),
	Small(8.dp),
	Medium(16.dp),
	Large(32.dp),
	ExtraLarge(64.dp)
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
				vertivalAlignment = Alignment.CenterVertically,
				content = content
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TDCardPreview(){
	TDCard {
		Text("Title ")
		Text("Content")
	}
}