package com.example.colorsimilaritygameapp.Components

import android.media.MediaPlayer
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.R
import com.example.colorsimilaritygameapp.ui.theme.Typography
import com.example.colorsimilaritygameapp.utils.getContrastColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Timer(
    backgroundColor: Color,
    totalTimeMillis: Long = 2_030L,
    onFinish: () -> Unit = {}
) {
    val context = LocalContext.current

    var timeLeft by remember { mutableStateOf(totalTimeMillis) }

    val tickPlayer = remember {
        MediaPlayer.create(context, R.raw.tick).apply {
            isLooping = true
        }
    }

    DisposableEffect(Unit) {
        tickPlayer.start()
        val job = kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
            val startTime = System.currentTimeMillis()
            while (true) {
                val elapsed = System.currentTimeMillis() - startTime
                timeLeft = (totalTimeMillis - elapsed).coerceAtLeast(0)
                if (timeLeft <= 0L) break
                delay(16L)
            }
            onFinish()
        }

        onDispose {
            job.cancel()
            tickPlayer.stop()
            tickPlayer.release()
        }
    }

    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val textColor = remember(backgroundColor) { getContrastColor(backgroundColor) }

    val seconds = timeLeft / 1000
    val hundredths = (timeLeft % 1000) / 10

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = String.format("%d.%02d", seconds, hundredths),
            style = Typography.displayLarge,
            color = textColor,
            modifier = Modifier.scale(scale)
        )
    }
}