package com.example.burntrack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun BodyPartButtonGrid(modifier: Modifier = Modifier, parts: List<String>) {
    // Split the list into chunks of 3
    val rows = parts.chunked(3)

    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        rows.forEach { row ->
            // For each row, create a horizontal row of buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { part ->
                    CircularButton(label = part)
                }
            }
            // Space between rows
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}