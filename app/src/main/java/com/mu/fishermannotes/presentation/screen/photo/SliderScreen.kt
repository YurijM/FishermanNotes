package com.mu.fishermannotes.presentation.screen.photo

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.fishermannotes.presentation.component.ImagesSlider
import com.mu.fishermannotes.presentation.navigation.Destinations.PhotoDestination

@Composable
fun SliderScreen(
    viewModel: SliderViewModel = hiltViewModel(),
    toPhoto: (PhotoDestination) -> Unit
) {
    ImagesSlider(
        imageList = viewModel.path,
        initialPage = viewModel.startPhoto,
        onClick = { path -> toPhoto(PhotoDestination(path)) }
    )
}