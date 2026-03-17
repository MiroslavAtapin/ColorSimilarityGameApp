package com.example.colorsimilaritygameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.colorsimilaritygameapp.screens.GameScreen
import com.example.colorsimilaritygameapp.ui.theme.ColorSimilarityGameAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorSimilarityGameAppTheme() {

//                HomeScreen()
                GameScreen()

            }
        }
    }
}

