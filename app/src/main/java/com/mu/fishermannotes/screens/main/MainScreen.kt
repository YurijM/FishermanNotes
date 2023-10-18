package com.mu.fishermannotes.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.mu.fishermannotes.navigation.NavGraph
import com.mu.fishermannotes.ui.theme.lightBlue100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController)
        },
        /*floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = lightBlue500,
                contentColor = lightBlue50,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },*/
        containerColor = lightBlue100
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = paddingValues.calculateBottomPadding() - 26.dp)
        ) {
            NavGraph(navController)
        }
    }
}