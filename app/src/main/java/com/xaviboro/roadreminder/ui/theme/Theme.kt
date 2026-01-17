package com.xaviboro.roadreminder.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


private val colorScheme = lightColorScheme(
    primary = Color(0xFF3B82F6),
    onPrimary = Color.White,
    secondary = Color(0xFF8B5CF6),
    onSecondary = Color.White,
    background = Color(0xFF000000),
    onBackground = Color.White,
    surface = Color(0xFF05070A),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF111418),


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(0.dp)
)

@Composable
fun RoadReminderTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}