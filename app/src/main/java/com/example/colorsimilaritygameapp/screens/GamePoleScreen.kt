package com.example.colorsimilaritygameapp.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.colorsimilaritygameapp.Components.AppButton
import com.example.colorsimilaritygameapp.Components.ButtonSize
import com.example.colorsimilaritygameapp.Components.Timer
import com.example.colorsimilaritygameapp.ui.theme.Gray
import com.example.colorsimilaritygameapp.utils.generateRandomColor

@Composable
fun GameScreen(){

    var backgroundColor by remember { mutableStateOf(Gray) }

    Scaffold(
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            AppButton(
                text = "Click",
                onClick = { backgroundColor = generateRandomColor() },
                size = ButtonSize.Default
            )
            Timer {  }
        }
    }

}

