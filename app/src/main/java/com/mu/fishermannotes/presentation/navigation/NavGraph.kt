package com.mu.fishermannotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mu.fishermannotes.presentation.navigation.destination.main.main
import com.mu.fishermannotes.presentation.navigation.destination.main.navigationToMain
import com.mu.fishermannotes.presentation.navigation.destination.splash.splash

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.SplashDestination
    ) {
        splash(
            toMain = { navController.navigationToMain() }
        )
        main()
    }
}