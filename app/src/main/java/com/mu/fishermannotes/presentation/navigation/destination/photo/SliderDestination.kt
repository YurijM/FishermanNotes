package com.mu.fishermannotes.presentation.navigation.destination.photo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.photo.SliderScreen

fun NavGraphBuilder.slider(
    toPhoto: (Destinations.PhotoDestination) -> Unit
) {
    composable<Destinations.SliderDestination> {
        SliderScreen(
            toPhoto = toPhoto
        )
    }
}