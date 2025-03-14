package com.example.burntrack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BodyPartButtonGrid(modifier: Modifier = Modifier, parts: List<String>,  navController: NavController) {
    // Split the list into chunks of 3
    val rows = parts.chunked(2)

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        rows.forEach { row ->
            // For each row, create a horizontal row of buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                row.forEach { part ->
                    CircularButton(label = part, navController)
                }
            }
            // Space between rows
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}