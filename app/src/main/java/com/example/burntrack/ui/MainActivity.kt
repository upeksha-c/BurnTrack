package com.example.burntrack.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.burntrack.ui.screens.ExcercisesScreen
import com.example.burntrack.ui.screens.HomeScreen
import com.example.burntrack.ui.screens.InfoScreen
import com.example.burntrack.ui.theme.BurnTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BurnTrackTheme {
                    BurnTrackApp()

            }
        }
    }
}

@Composable
fun BurnTrackApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable(route = "home") { HomeScreen(navController) }
        composable(route = "info") { InfoScreen(navController) }
        composable(route = "matching_result") { ExcercisesScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun BurnTrackPreview() {
    BurnTrackTheme {
        BurnTrackApp()
    }
}