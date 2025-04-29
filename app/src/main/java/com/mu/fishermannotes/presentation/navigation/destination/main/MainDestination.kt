package com.mu.fishermannotes.presentation.navigation.destination.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.main.MainScreen

fun NavGraphBuilder.main() {
    composable<Destinations.MainDestination> {
        MainScreen()
    }
}