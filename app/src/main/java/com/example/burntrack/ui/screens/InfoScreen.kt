package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.burntrack.ui.components.ScreenTopAppBar

@Composable
fun InfoScreen(navController: NavController){
    Scaffold(
        topBar = {ScreenTopAppBar("Info", navController)},
    ){innerPadding ->
        Text(
            text = "Info Screen",
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}