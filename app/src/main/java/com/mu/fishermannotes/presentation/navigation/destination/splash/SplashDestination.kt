package com.mu.fishermannotes.presentation.navigation.destination.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.splash.SplashScreen

fun NavGraphBuilder.splash(
    toMain: () -> Unit
) {
    composable<Destinations.SplashDestination> {
        SplashScreen(
            toMain = toMain
        )
    }
}