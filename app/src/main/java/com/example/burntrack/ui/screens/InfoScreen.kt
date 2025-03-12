package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.burntrack.ui.components.ScreenTopAppBar

@Composable
fun InfoScreen(navController: NavController){
    Scaffold(
        topBar = {ScreenTopAppBar("Info", navController)},
    ){innerPadding ->
        Text(
            text = "Welcome to BurnTrack – your personal fitness companion! BurnTrack helps you discover the best exercises for different muscle groups with ease. Whether you're a beginner or a fitness expert, this app provides a structured way to explore workouts tailored to your needs.",
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 30.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}