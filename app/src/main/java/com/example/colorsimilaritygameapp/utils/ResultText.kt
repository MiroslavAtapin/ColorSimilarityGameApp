package com.example.colorsimilaritygameapp.utils

fun getResultText(percent: Int): String {
    return when (percent) {
        in 90..100 -> "Идеально! Ты человек-палитра 🎨"
        in 75..89 -> "Очень близко! Отличный глаз 👀"
        in 60..74 -> "Неплохо! Есть чувство цвета 👍"
        in 40..59 -> "Средне, можно лучше 🙂"
        in 20..39 -> "Пока далековато 😅"
        else -> "Это было... неожиданно 😂"
    }
}