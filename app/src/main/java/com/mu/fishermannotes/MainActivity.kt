package com.mu.fishermannotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mu.fishermannotes.presentation.navigation.NavGraph
import com.mu.fishermannotes.ui.theme.FishermanNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            FishermanNotesTheme {
                Scaffold(
                    /*containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,*/
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    //MainScreen()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
