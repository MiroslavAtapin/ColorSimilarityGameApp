package com.example.colorsimilaritygameapp.utils

import androidx.compose.ui.graphics.Color
import kotlin.math.pow
import kotlin.math.sqrt

fun calculateSimilarity(color1: Color, color2: Color): Int {
    val lab1 = rgbToLab(color1)
    val lab2 = rgbToLab(color2)

    val deltaE = deltaE(lab1, lab2)

    // Максимально возможное DeltaE ≈ 100
    val similarity = (1 - deltaE / 100) * 100

    return similarity.toInt().coerceIn(0, 100)
}

// ---------- RGB → LAB ----------

private fun rgbToLab(color: Color): DoubleArray {
    val r = pivotRgb(color.red)
    val g = pivotRgb(color.green)
    val b = pivotRgb(color.blue)

    // RGB → XYZ
    val x = r * 0.4124 + g * 0.3576 + b * 0.1805
    val y = r * 0.2126 + g * 0.7152 + b * 0.0722
    val z = r * 0.0193 + g * 0.1192 + b * 0.9505

    // Нормализация под D65
    val xn = 0.95047
    val yn = 1.00000
    val zn = 1.08883

    val fx = pivotXyz(x / xn)
    val fy = pivotXyz(y / yn)
    val fz = pivotXyz(z / zn)

    val l = 116 * fy - 16
    val a = 500 * (fx - fy)
    val bLab = 200 * (fy - fz)

    return doubleArrayOf(l, a, bLab)
}

private fun pivotRgb(value: Float): Double {
    val v = value.toDouble()
    return if (v > 0.04045)
        ((v + 0.055) / 1.055).pow(2.4)
    else
        v / 12.92
}

private fun pivotXyz(value: Double): Double {
    return if (value > 0.008856)
        value.pow(1.0 / 3.0)
    else
        (7.787 * value) + (16.0 / 116.0)
}

// ---------- Delta E ----------

private fun deltaE(lab1: DoubleArray, lab2: DoubleArray): Double {
    val dl = lab1[0] - lab2[0]
    val da = lab1[1] - lab2[1]
    val db = lab1[2] - lab2[2]

    return sqrt(dl * dl + da * da + db * db)
}