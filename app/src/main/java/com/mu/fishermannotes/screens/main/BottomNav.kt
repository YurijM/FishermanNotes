package com.mu.fishermannotes.screens.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mu.fishermannotes.ui.theme.lightBlue100
import com.mu.fishermannotes.ui.theme.lightBlue200
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue500

@Composable
fun BottomNav(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.FishingItem,
        BottomNavItem.LocationItem
    )
    BottomAppBar(
        containerColor = lightBlue50
    ) {
        items.forEach { item ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            NavigationBarItem(
                selected = (currentRoute == item.route),
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.item
                    )
                },
                label = {
                    Text(text = item.item)
                },
                //alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = lightBlue500,
                    selectedTextColor = lightBlue500,
                    indicatorColor = lightBlue100,
                    unselectedIconColor = lightBlue200,
                    unselectedTextColor = lightBlue200
                )
            )

        }
    }
}