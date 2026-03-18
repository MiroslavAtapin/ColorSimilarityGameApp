package com.example.colorsimilaritygameapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.colorsimilaritygameapp.Components.ChooseColor
import com.example.colorsimilaritygameapp.Components.Result
import com.example.colorsimilaritygameapp.Components.Timer
import com.example.colorsimilaritygameapp.ui.theme.Gray
import com.example.colorsimilaritygameapp.utils.generateRandomColor
import kotlinx.coroutines.delay

@Composable
fun GameScreen() {

    var originalColor by remember { mutableStateOf(generateRandomColor()) }
    var backgroundColor by remember { mutableStateOf(originalColor) }
    var isTimerRunning by remember { mutableStateOf(false) }
    var showColorPicker by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }
    var userColor by remember { mutableStateOf(Color.White) }

    LaunchedEffect(Unit) {
        delay(500)
        isTimerRunning = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Таймер
        if (isTimerRunning) {
            Timer(
                onFinish = {
                    isTimerRunning = false
                    backgroundColor = Gray
                    showColorPicker = true
                }
            )
        }

        // Выбор цвета
        if (showColorPicker) {
            ChooseColor(
                onColorSelected = { color ->
                    userColor = color
                    showColorPicker = false
                    showResult = true
                },
                onColorChanging = { color ->
                    backgroundColor = color
                }
            )
        }

        // Результат
        if (showResult) {
            Result(
                originalColor = originalColor,
                userColor = userColor,
                onRestart = {
                    originalColor = generateRandomColor()
                    backgroundColor = originalColor
                    showResult = false
                    showColorPicker = false
                    isTimerRunning = true
                }
            )
        }
    }
}