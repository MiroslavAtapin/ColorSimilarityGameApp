package com.example.colorsimilaritygameapp.Components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import com.example.colorsimilaritygameapp.ui.theme.Typography
import kotlinx.coroutines.delay

@Composable
fun Timer(
    totalTimeMillis: Long = 2_030L,
    onFinish: () -> Unit = {}
) {
    var timeLeft by remember { mutableStateOf(totalTimeMillis) }

    // Пульсирующая анимация
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(Unit) {
        val startTime = System.currentTimeMillis()
        while (true) {
            val elapsed = System.currentTimeMillis() - startTime
            timeLeft = (totalTimeMillis - elapsed).coerceAtLeast(0)
            if (timeLeft <= 0L) break
            delay(16L)
        }
        onFinish()
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppCard(size = CardSize.Small, modifier = Modifier.align(Alignment.TopCenter)) {
            val seconds = timeLeft / 1000
            val hundredths = (timeLeft % 1000) / 10
            Box(
                modifier = Modifier.scale(scale)
            ) {
                Text(
                    text = String.format("%d.%02d", seconds, hundredths),
                    style = Typography.headlineLarge
                )
            }
        }
    }
}