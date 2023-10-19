package com.mu.fishermannotes.screens.location

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LocationListScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(7) {
            LocationItem()
        }
    }
}