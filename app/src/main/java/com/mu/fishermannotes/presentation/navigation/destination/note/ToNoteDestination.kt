package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteDestination
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteListDestination

fun NavController.navigationToNote(args: NoteDestination) {
    navigate(NoteDestination(args.id)) {
        popUpTo(NoteListDestination)
    }
}