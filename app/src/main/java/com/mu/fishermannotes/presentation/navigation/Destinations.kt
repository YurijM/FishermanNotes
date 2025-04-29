package com.mu.fishermannotes.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object SplashDestination : Destinations()
    @Serializable
    data object MainDestination : Destinations()
    @Serializable
    data object NoteListDestination : Destinations()
}