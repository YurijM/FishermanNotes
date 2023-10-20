package com.mu.fishermannotes.screens.main

import com.mu.fishermannotes.R
import com.mu.fishermannotes.consts.Routes

sealed class BottomNavItem(
    val item: String,
    val iconId: Int,
    val route: String
) {
    object FishingItem: BottomNavItem(
        item = "Рыбалка",
        iconId = R.drawable.fishing,
        route = Routes.FISHING_LIST
    )
    object LocationItem: BottomNavItem(
        item = "Водоёмы",
        iconId = R.drawable.location,
        route = Routes.LOCATION_LIST
    )
}
