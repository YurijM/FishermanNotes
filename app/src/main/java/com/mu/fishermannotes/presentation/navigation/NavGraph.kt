package com.mu.fishermannotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mu.fishermannotes.presentation.navigation.Destinations.SplashDestination
import com.mu.fishermannotes.presentation.navigation.destination.main.main
import com.mu.fishermannotes.presentation.navigation.destination.main.navigationToMain
import com.mu.fishermannotes.presentation.navigation.destination.note.navigationToNote
import com.mu.fishermannotes.presentation.navigation.destination.note.navigationToNoteList
import com.mu.fishermannotes.presentation.navigation.destination.note.note
import com.mu.fishermannotes.presentation.navigation.destination.note.noteList
import com.mu.fishermannotes.presentation.navigation.destination.photo.navigationToPhoto
import com.mu.fishermannotes.presentation.navigation.destination.photo.navigationToSlider
import com.mu.fishermannotes.presentation.navigation.destination.photo.photo
import com.mu.fishermannotes.presentation.navigation.destination.photo.slider
import com.mu.fishermannotes.presentation.navigation.destination.splash.splash

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Destinations = SplashDestination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        splash(
            toMain = { navController.navigationToMain() }
        )
        main()
        noteList(
            toNote = { args ->
                navController.navigationToNote(args)
            }
        )
        note(
            toNoteList = { navController.navigationToNoteList() },
            toSlider = { args ->
                navController.navigationToSlider(args)
            }
        )
        slider(
            toPhoto = { args ->
                navController.navigationToPhoto(args)
            }
        )
        photo()
    }
}