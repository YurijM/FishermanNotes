package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations

fun NavController.navigationToNote() {
    navigate(Destinations.NoteDestination) {
        popUpTo(Destinations.NoteListDestination)
    }
}