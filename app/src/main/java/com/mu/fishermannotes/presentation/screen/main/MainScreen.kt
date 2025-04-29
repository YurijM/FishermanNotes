package com.mu.fishermannotes.presentation.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mu.fishermannotes.presentation.component.ApplicationBar
import com.mu.fishermannotes.presentation.component.BottomBar
import com.mu.fishermannotes.presentation.navigation.Destinations
import com.mu.fishermannotes.presentation.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    //val navBackStackEntry by navController.currentBackStackEntryAsState()  //by navController
    // .currentBackStackEntryAsState()
    //val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomBar()
        },
        topBar = {
            ApplicationBar()
        }
    ) { paddingValues ->
        Surface(
            contentColor = MaterialTheme.colorScheme.primary,
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                ),
        ) {
            NavGraph(
                navController = navController,
                startDestination = Destinations.NoteListDestination
            )
        }
    }
}