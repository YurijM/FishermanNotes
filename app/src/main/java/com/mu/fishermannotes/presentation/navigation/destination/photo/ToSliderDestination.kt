package com.mu.fishermannotes.presentation.navigation.destination.photo

import androidx.navigation.NavController
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.navigation.Destinations.SliderDestination

fun NavController.navigationToSlider(args: SliderDestination) {
    navigate(SliderDestination(args.noteId, args.path, args.startPhoto)) {
        popUpTo(Destinations.NoteDestination(args.noteId))
    }
}