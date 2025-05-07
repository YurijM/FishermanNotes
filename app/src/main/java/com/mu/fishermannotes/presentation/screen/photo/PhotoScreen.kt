package com.mu.fishermannotes.presentation.screen.photo

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun PhotoScreen(
    viewModel: PhotoViewModel = hiltViewModel()
) {
    Image(
        painter = rememberAsyncImagePainter(model = viewModel.path),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}