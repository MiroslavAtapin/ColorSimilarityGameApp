package com.example.colorsimilaritygameapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.colorsimilaritygameapp.Components.AppButton
import com.example.colorsimilaritygameapp.Components.ButtonSize
import com.example.colorsimilaritygameapp.R
import com.example.colorsimilaritygameapp.ui.theme.PrimaryLight
import com.example.colorsimilaritygameapp.ui.theme.Typography

@Composable
fun HomeScreen(navController: NavHostController) {

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
                onClick = {
                    navController.navigate("game")
                },
                modifier = Modifier.fillMaxWidth(),
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