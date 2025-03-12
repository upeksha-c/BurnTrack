package com.example.burntrack.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.burntrack.ui.screens.ExercisesScreen
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
        composable(route = "exercises_screen/{bodyPart}") { backStackEntry ->
            val bodyPart = backStackEntry.arguments?.getString("bodyPart") ?: "Unknown"
            ExercisesScreen(navController =navController, bodyPart = bodyPart) }
    }
}

@Preview(showBackground = true)
@Composable
fun BurnTrackPreview() {
    BurnTrackTheme {
        BurnTrackApp()
    }
}