package com.mu.fishermannotes.presentation.navigation.destination.photo

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.navigation.Destinations.PhotoDestination

fun NavController.navigationToPhoto(args: PhotoDestination) {
    navigate(PhotoDestination(args.noteId, args.path)) {
        popUpTo(Destinations.NoteDestination(args.noteId))
    }
}