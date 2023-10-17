package com.mu.fishermannotes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mu.fishermannotes.consts.Routes
import com.mu.fishermannotes.screens.fishing.FishingListScreen
import com.mu.fishermannotes.screens.location.LocationListScreen

@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Routes.FISHING_LIST
    ) {
        composable(Routes.FISHING_LIST) {
            FishingListScreen(padding.calculateBottomPadding())
        }
        composable(Routes.LOCATION_LIST) {
            LocationListScreen(padding.calculateBottomPadding())
        }
    }
}