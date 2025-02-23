package com.main.taskadoo_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorsPallet = darkColorScheme(
    primary = BlueDark,
    onPrimary = PurpleGreyDark,
    primaryContainer = GreenDark,
    inversePrimary = BlueDark,
    secondary = GreenDark,
    onSecondary = BlueDark,
    tertiary = GreenDark,
    onTertiaryContainer = BlueDark,
    surface = GreenDark,
    onSurface = BlueDark,
    surfaceVariant = GreenLight,
    onSurfaceVariant = BlueDark,
    surfaceTint = GreenLight,
    inverseSurface = BlueDark,
    error = Error
)

private val LightColorsPallet = lightColorScheme(
    primary = PurpleLight,
    onPrimary = PurpleGreyLight,
    primaryContainer = PinkLight,
    inversePrimary = BlueDark,
    secondary = GreenLight,
    onSecondary = BlueLight,
    tertiary = GreenLight,
    onTertiaryContainer = BlueLight,
    surface = GreenLight,
    onSurface = BlueLight,
    surfaceVariant = GreenDark,
    onSurfaceVariant = BlueLight,
    surfaceTint = PurpleLight,
    inverseSurface = BlueLight,
    error = Error
)

@Composable
fun ComposeTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit)
{
    val theme = if (darkTheme) {
        DarkColorsPallet
    } else {
        LightColorsPallet
    }

    MaterialTheme(
        colorScheme = theme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}