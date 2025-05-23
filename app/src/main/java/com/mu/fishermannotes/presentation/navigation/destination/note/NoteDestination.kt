package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.note.NoteScreen

fun NavGraphBuilder.note(
    toNoteList: () -> Unit,
    toSlider: (Destinations.SliderDestination) -> Unit
) {
    composable<Destinations.NoteDestination> {
        NoteScreen(
            toNoteList = toNoteList,
            toSlider = toSlider,
        )
    }
}