package com.example.burntrack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.burntrack.ui.components.AppTitle
import com.example.burntrack.ui.components.MainTopBar


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold (
        topBar = { MainTopBar("BurnTrack", navController) }
    ){ innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {

        }
    }


}