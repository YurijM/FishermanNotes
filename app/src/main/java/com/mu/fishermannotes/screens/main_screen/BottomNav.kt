package com.mu.fishermannotes.screens.main_screen

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mu.fishermannotes.ui.theme.lightBlue200
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue500

@Composable
fun BottomNav() {
    val items = listOf(
        BottomNavItem.FishingItem,
        BottomNavItem.LocationItem
    )
    BottomAppBar(
        containerColor = lightBlue50
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = (index == 1),
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.item
                    )
                },
                label = {
                    Text(text = item.item)
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = lightBlue500,
                    selectedTextColor = lightBlue500,
                    unselectedIconColor = lightBlue200
                )
            )

        }
    }
}