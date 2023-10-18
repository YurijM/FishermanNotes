package com.mu.fishermannotes.screens.fishing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FishingListScreen() {
    /*Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingBottom)
            .wrapContentSize(),
        text = "Fishing Screen",
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = lightBlue900
    )*/
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(4) {
            FishingItemScreen()
        }
    }
}