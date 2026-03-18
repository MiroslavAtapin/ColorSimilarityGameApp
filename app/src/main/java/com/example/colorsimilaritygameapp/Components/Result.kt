package com.example.colorsimilaritygameapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
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
){

    val similarity = calculateSimilarity(originalColor, userColor)
    val resultText = getResultText(similarity)

    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(originalColor)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(userColor)
            )
        }

        AppCard(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
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
                    onClick = onRestart
                )
            }
        }
    }
}