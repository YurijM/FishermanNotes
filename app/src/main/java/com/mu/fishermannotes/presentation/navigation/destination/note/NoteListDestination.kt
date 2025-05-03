package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteListDestination
import com.mu.fishermannotes.presentation.screen.note.list.NoteListScreen

fun NavGraphBuilder.noteList(
    toNote: (NoteDestination) -> Unit
) {
    composable<NoteListDestination> {
        NoteListScreen(
            toNote = toNote
        )
    }
}