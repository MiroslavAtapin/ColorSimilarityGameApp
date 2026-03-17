package com.example.colorsimilaritygameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.colorsimilaritygameapp.ui.theme.ColorSimilarityGameAppTheme
import com.example.colorsimilaritygameapp.Screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorSimilarityGameAppTheme() {

                HomeScreen()

            }
        }
    }
}

