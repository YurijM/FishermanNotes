package com.mu.fishermannotes.screens.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mu.fishermannotes.ui.theme.lightBlue100
import com.mu.fishermannotes.ui.theme.lightBlue50
import com.mu.fishermannotes.ui.theme.lightBlue500

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            BottomNav()
        },
        floatingActionButton = {
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
        },
        containerColor = lightBlue100
    ) {

    }
}