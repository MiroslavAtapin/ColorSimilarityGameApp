package com.example.colorsimilaritygameapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
        delay(150)
        isTimerRunning = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

        AnimatedVisibility(
            visible = isTimerRunning,
            enter = fadeIn(animationSpec = tween(500)) +
                    slideInVertically(initialOffsetY = { -it }, animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(300)) +
                    slideOutVertically(targetOffsetY = { -it }, animationSpec = tween(300))
        ) {
            Timer(
                backgroundColor = backgroundColor,
                onFinish = {
                    isTimerRunning = false
                    showColorPicker = true
                }
            )
        }

        AnimatedVisibility(
            visible = showColorPicker,
            enter = fadeIn(animationSpec = tween(500)) +
                    slideInVertically(initialOffsetY = { it }, animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(300)) +
                    slideOutVertically(targetOffsetY = { it }, animationSpec = tween(300))
        ) {
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