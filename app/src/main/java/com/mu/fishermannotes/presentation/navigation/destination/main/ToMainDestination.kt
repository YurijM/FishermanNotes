package com.mu.fishermannotes.presentation.navigation.destination.main

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations

fun NavController.navigationToMain() {
    navigate(Destinations.MainDestination) {
        popUpTo(Destinations.SplashDestination)
    }
}