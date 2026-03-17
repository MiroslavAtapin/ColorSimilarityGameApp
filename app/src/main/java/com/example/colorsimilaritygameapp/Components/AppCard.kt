package com.example.colorsimilaritygameapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.ui.theme.BackgroundLight
import com.example.colorsimilaritygameapp.ui.theme.Typography

@Composable
fun AppCard(
    size: CardSize = CardSize.Default,
    content: @Composable () -> Unit = {}
){

    val padding = when(size){
        CardSize.Default -> 32.dp
        CardSize.Small -> 16.dp
    }

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(BackgroundLight)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = padding),
            contentAlignment = Alignment.Center)
        {
            content()
        }
    }

}

enum class CardSize {
    Default,
    Small
}
