package com.mu.fishermannotes.screens.main_screen

import com.mu.fishermannotes.R

sealed class BottomNavItem(
    val item: String,
    val iconId: Int,
    val route: String
) {
    object FishingItem: BottomNavItem(
        item = "Рыбалка",
        iconId = R.drawable.ic_fisherman,
        route = "fishing"
    )
    object LocationItem: BottomNavItem(
        item = "Водоёмы",
        iconId = R.drawable.ic_fisherman,
        route = "location"
    )
}
