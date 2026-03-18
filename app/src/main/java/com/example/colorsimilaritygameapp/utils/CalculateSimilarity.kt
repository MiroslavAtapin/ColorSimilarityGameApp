package com.example.colorsimilaritygameapp.utils

fun calculateSimilarity(color1: androidx.compose.ui.graphics.Color, color2: androidx.compose.ui.graphics.Color): Int {
    val r1 = color1.red * 255
    val g1 = color1.green * 255
    val b1 = color1.blue * 255

    val r2 = color2.red * 255
    val g2 = color2.green * 255
    val b2 = color2.blue * 255

    val distance = kotlin.math.sqrt(
        (r1 - r2) * (r1 - r2) +
                (g1 - g2) * (g1 - g2) +
                (b1 - b2) * (b1 - b2)
    )

    val maxDistance = kotlin.math.sqrt(3 * 255.0 * 255.0)

    val similarity = (1 - distance / maxDistance) * 100

    return similarity.toInt().coerceIn(0, 100)
}