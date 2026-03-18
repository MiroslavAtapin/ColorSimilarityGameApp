package com.example.colorsimilaritygameapp.Components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.ui.theme.Typography
import com.example.colorsimilaritygameapp.utils.calculateSimilarity
import com.example.colorsimilaritygameapp.utils.getResultText

@Composable
fun Result(
    originalColor: Color,
    userColor: Color,
    onRestart: () -> Unit
) {
    val similarity = calculateSimilarity(originalColor, userColor)
    val resultText = getResultText(similarity)

    var showColors by remember { mutableStateOf(false) }
    var showCard by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        showColors = true
        kotlinx.coroutines.delay(700)
        showCard = true
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = showColors,
                enter = fadeIn(animationSpec = tween(700)) +
                        slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween(700)
                        ),
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(originalColor)
                )
            }

            AnimatedVisibility(
                visible = showColors,
                enter = fadeIn(animationSpec = tween(700, delayMillis = 300)) +
                        slideInHorizontally(
                            initialOffsetX = { it },
                            animationSpec = tween(700, delayMillis = 300)
                        ),
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(userColor)
                )
            }
        }

        val rgbOriginal = "${(originalColor.red * 255).toInt()}, ${(originalColor.green * 255).toInt()}, ${(originalColor.blue * 255).toInt()}"
        val rgbUser = "${(userColor.red * 255).toInt()}, ${(userColor.green * 255).toInt()}, ${(userColor.blue * 255).toInt()}"

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AppCard (
                size = CardSize.Small
            ){
                Text(rgbOriginal, style = Typography.bodyLarge)
            }
            AppCard (
                size = CardSize.Small
            ){
                Text(rgbUser, style = Typography.bodyLarge)
            }
        }

        AnimatedVisibility(
            visible = showCard,
            enter = fadeIn(animationSpec = tween(450)),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            AppCard {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$similarity%",
                        style = Typography.displaySmall
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = resultText,
                        style = Typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    AppButton(
                        text = "Продолжить",
                        onClick = onRestart,
                        size = ButtonSize.Small,
                    )
                }
            }
        }
    }
}
