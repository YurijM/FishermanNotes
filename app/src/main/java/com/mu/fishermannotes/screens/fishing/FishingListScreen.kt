package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mu.fishermannotes.ui.theme.lightBlue900

@Composable
fun FishingListScreen() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        text = "Fishing Screen",
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = lightBlue900
    )
}