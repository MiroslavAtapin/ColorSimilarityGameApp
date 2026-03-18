package com.example.colorsimilaritygameapp.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.ui.theme.BackgroundLight

@Composable
fun AppCard(
    size: CardSize = CardSize.Default,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {},
){

    val padding = when(size){
        CardSize.Default -> 32.dp
        CardSize.Small -> 16.dp
    }

    Card(
        modifier = modifier.padding(bottom = 40.dp, top = 70.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(BackgroundLight),

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
