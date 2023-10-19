package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.mu.fishermannotes.ui.theme.lightBlue500

@Composable
fun ResultItem() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "Кол-во:")
            Text(
                text = "12",
                color = lightBlue500,
                fontWeight = FontWeight.Black
            )
            Text(
                text = "шт."
            )
        }
        Row {
            Text(
                text = "Вес:"
            )
            Text(
                text = "1.2",
                color = lightBlue500,
                fontWeight = FontWeight.Black
            )
            Text(
                text = "кг"
            )
        }
    }
}
