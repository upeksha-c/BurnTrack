package com.example.burntrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.burntrack.ui.screens.HomeScreen
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
    }
}

@Preview(showBackground = true)
@Composable
fun BurnTrackPreview() {
    BurnTrackTheme {
        BurnTrackApp()
    }
}