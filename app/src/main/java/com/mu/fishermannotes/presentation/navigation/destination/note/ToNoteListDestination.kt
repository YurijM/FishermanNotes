package com.mu.fishermannotes.presentation.navigation.destination.note

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations.NoteListDestination

fun NavController.navigationToNoteList() {
    navigate(NoteListDestination) {
        //popUpTo(NoteListDestination)
    }
}