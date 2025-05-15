package com.mu.fishermannotes.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object SplashDestination : Destinations()
    @Serializable
    data object MainDestination : Destinations()
    @Serializable
    data object NoteListDestination : Destinations()
    @Serializable
    data class NoteDestination(val id: Long) : Destinations()
    @Serializable
    data class SliderDestination(
        val noteId: Long,
        val path: MutableList<String>,
        val startPhoto: Int
    ) : Destinations()
    @Serializable
    data class PhotoDestination(val path: String) : Destinations()
}