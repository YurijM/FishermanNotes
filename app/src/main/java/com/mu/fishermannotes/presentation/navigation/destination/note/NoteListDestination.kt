package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.screen.note.list.NoteListScreen

fun NavGraphBuilder.noteList() {
    composable<Destinations.NoteListDestination> {
        NoteListScreen()
    }
}