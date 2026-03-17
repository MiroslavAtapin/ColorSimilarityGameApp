package com.example.colorsimilaritygameapp.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.Components.AppButton
import com.example.colorsimilaritygameapp.Components.ButtonSize
import com.example.colorsimilaritygameapp.R
import com.example.colorsimilaritygameapp.ui.theme.PrimaryLight
import com.example.colorsimilaritygameapp.ui.theme.Typography

@Composable
fun HomeScreen(){

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TitleApp()
            Spacer(modifier = Modifier.height(80.dp))
            BackgroundImg()
            Spacer(modifier = Modifier.height(80.dp))
            AppButton(
                "Играть",
                onClick = {},
                size = ButtonSize.Default
            )
        }
    }

}

@Composable
fun TitleApp(){
    Text(
        "Color similarity game",
        style = Typography.displayMedium,
        color = PrimaryLight,
        textAlign = TextAlign.Center
    )
}

@Composable
fun BackgroundImg(){
    Image(
        painter = painterResource(R.drawable.back),
        contentDescription = "Background image",
        contentScale = ContentScale.Fit
    )
}