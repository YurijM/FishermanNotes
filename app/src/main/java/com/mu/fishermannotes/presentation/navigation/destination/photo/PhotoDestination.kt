package com.mu.fishermannotes.presentation.navigation.destination.photo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.photo.PhotoScreen

fun NavGraphBuilder.photo() {
    composable<Destinations.PhotoDestination> {
        PhotoScreen()
    }
}