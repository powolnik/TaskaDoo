package com.main.taskadoo_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorsPallet = darkColorScheme(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    tertiary = TertiaryDark,
    onPrimary = OnPrimaryDark,
    onSecondary = OnSecondaryDark,
    onTertiary = OnTertiaryDark,

    // Containers
    primaryContainer = PrimaryContainerDark,
    secondaryContainer = SecondaryContainerDark,

    // Background and surface
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    background = BackgroundDark,

    error = Error
)

private val LightColorsPallet = lightColorScheme(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    tertiary = TertiaryLight,
    onPrimary = OnPrimaryLight,
    onSecondary = OnSecondaryLight,
    onTertiary = OnTertiaryLight,

    // Containers
    primaryContainer = PrimaryContainerLight,
    secondaryContainer = SecondaryContainerLight,

    // Background and surface
    surface = SurfaceLight,
    background = BackgroundLight,

    onSurface = OnSurfaceLight,

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