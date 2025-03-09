package com.main.taskadoo_app.src

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.main.taskadoo_app.ui.theme.Typography

/*** A composable function that displays text with custom styling.
 *
 * This function wraps the standard [Text] composable to apply padding and a background,
 * using the provided text color, background color, and text style.
 *
 * @param text The text string to display.
 * @param modifier The [Modifier] to be applied to this text. Defaults to [Modifier].
 * @param textColor The color of the text. Defaults to [MaterialTheme.colorScheme.onBackground].
 * @param backgroundColor The background color behind the text. Defaults to [MaterialTheme.colorScheme.background].
 * @param textStyle The [TextStyle] applied to the text. Defaults to [Typography.displaySmall].*/
@Composable
fun TDText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textBackground: Color = MaterialTheme.colorScheme.primary,
    paddingValues: Int = 10,
    textStyle: TextStyle = Typography.displaySmall
) {
    Text(
        text = text,
        modifier = modifier
            .padding(paddingValues.dp)
            .background(color = textBackground, shape = RectangleShape),
        style = textStyle.copy(color = textColor)
    )
}

/*** A composable function that renders a custom button.
 *
 * This button displays a text label and executes an action when clicked.
 * If no action is provided (i.e. if [onClickAction] is null), it shows a Toast with the message "DEFAULT".
 *
 * @param name The text label to display on the button.
 * @param onClickAction The lambda function to be executed when the button is clicked.
 *                      If null, a default Toast message is shown.
 * @param containerColor The background color of the button, typically from the MaterialTheme's primary color.
 *                       Defaults to [MaterialTheme.colorScheme.primary].
 * @param contentColor The color used for the button's content (e.g., text), typically from the MaterialTheme's onPrimary color.
 *                     Defaults to [MaterialTheme.colorScheme.onPrimary].*/
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
        TDText(name)
    }
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
fun TDColumn(modifier: Modifier = Modifier,
             arrangement: Arrangement.Vertical = Arrangement.Bottom,
             content: @Composable ColumnScope.() -> Unit,
             ) {
    Column(modifier = modifier
        .padding(16.dp),
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
fun TDRow(modifier: Modifier = Modifier,
          arrangement: Arrangement.Vertical = Arrangement.Bottom,
          content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = content
    )
}

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
    placeholder: String = "",
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        textStyle = Typography.displaySmall,
        singleLine = isSingleLine
    )
}

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

//@Composable
//fun TDCard(
//    modifier: Modifier = Modifier,
//    shape: Shape = Shapes.medium,
//    content: @Composable () -> Unit,
//    arrangement: Arrangement.Vertical = Arrangement.Bottom,
//) {
//    Card(Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clickable {
//
//            },
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
//    ) {
//        content()
//    }
//}
//

//@Composable
/*fun CxR(row_count: Int = 1, column_count: Int = 1) {
    run {
        for (i in 1..row_count) {
            TDColumn{
                for (i in 1..row_count) {
                    TDRow {}
                }
            }
        }
    }
}*/
//e: file:///P:/_Repositories/TaskaDoo/taskadoo_app/app/src/main/java/com/main/taskadoo_app/src/BasicTypes.kt:181:5 None of the following candidates is applicable:
//fun Card(onClick: () -> U...,
// modifier: Modifier = ...,
//
// enabled: Boolean = ...,
// shape: Shape = ...,
// colors: CardColors = ...,
// elevation: CardElevation = ...,
// border: BorderStroke? = ...,
// interactionSource: MutableInteractionSource? = ...,
// content: @Composable() ComposableFunction1<ColumnSc...,
// Unit>): Unit
//fun Card(modifier: Modifier = ...,
// shape: Shape = ...,
// colors: CardColors = ...,
// elevation: CardElevation = ...,
// border: BorderStroke? = ...,
// content: @Composable() ComposableFunction1<ColumnScope