package com.example.colorsimilaritygameapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance


fun getContrastColor(color: Color): Color {
    return if (color.luminance() > 0.5f) {
        color.copy(
            red = color.red * 0.4f,
            green = color.green * 0.4f,
            blue = color.blue * 0.4f
        )
    } else {
        color.copy(
            red = (color.red + 1f) / 2f,
            green = (color.green + 1f) / 2f,
            blue = (color.blue + 1f) / 2f
        )
    }
}