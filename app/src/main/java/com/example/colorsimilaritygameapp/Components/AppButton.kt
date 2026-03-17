package com.example.colorsimilaritygameapp.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.colorsimilaritygameapp.ui.theme.Typography

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    size: ButtonSize = ButtonSize.Default
){

//    val height = when(size){
//        ButtonSize.Default-> 52.dp
//        ButtonSize.Small -> 28.dp
//    }

    val textStyle = when(size){
        ButtonSize.Default -> Typography.titleMedium
        ButtonSize.Small -> Typography.titleSmall
    }

    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Black),
        elevation = ButtonDefaults.buttonElevation(6.dp),
        shape = RoundedCornerShape(24.dp)

    ) {
        Text(
            text,
            modifier = Modifier.padding(32.dp, 10.dp),
            style = textStyle,
            color = Color.White,
        )
    }

}

enum class ButtonSize {
    Default,
    Small
}
