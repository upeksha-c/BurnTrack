package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.burntrack.R
import com.example.burntrack.ui.components.ScreenTopAppBar

@Composable
fun InfoScreen(navController: NavController){
    Scaffold(
        topBar = {ScreenTopAppBar(stringResource(R.string.info), navController)},
    ){innerPadding ->
        Text(
            text = stringResource(R.string.description),
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 30.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}