package com.example.colorsimilaritygameapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.ui.theme.PrimaryLight
import io.mhssn.colorpicker.ColorPicker
import io.mhssn.colorpicker.ColorPickerType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChooseColor(){

    var selectedColor by remember { mutableStateOf(PrimaryLight) }

    AppCard {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(selectedColor),
            )

            Spacer(modifier = Modifier.height(24.dp))

            ColorPicker(
                type = ColorPickerType.Classic()
            ) { color -> selectedColor = color }

            Spacer(modifier = Modifier.height(24.dp))

            AppButton(
                text = "Выбрать",
                onClick = {},
                size = ButtonSize.Small
            )
        }
    }

}