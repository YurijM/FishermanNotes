package com.mu.fishermannotes.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mu.fishermannotes.ui.theme.lightBlue100
import com.mu.fishermannotes.ui.theme.lightBlue200
import com.mu.fishermannotes.ui.theme.lightBlue400
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue500


@Composable
fun BottomNav(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.FishingItem,
        BottomNavItem.LocationItem
    )
    ConstraintLayout {
        val (navBar, fab) = createRefs()
        BottomAppBar(
            modifier = Modifier.constrainAs(navBar) {
                //top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            containerColor = Color.White //lightBlue50
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
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = item.iconId),
                            contentDescription = item.item
                        )
                    },
                    label = {
                        Text(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .wrapContentSize(),
                            text = item.item
                        )
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
        FloatingActionButton(
            modifier = Modifier.constrainAs(fab) {
                top.linkTo(navBar.top)
                bottom.linkTo(navBar.top)
                start.linkTo(navBar.start)
                end.linkTo(navBar.end)
            },
            onClick = { },
            containerColor = lightBlue400,
            contentColor = lightBlue50,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}