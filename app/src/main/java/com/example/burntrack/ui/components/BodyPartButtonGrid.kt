package com.example.burntrack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BodyPartButtonGrid(modifier: Modifier = Modifier, parts: List<String>) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(3),
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        items(parts) { part ->
            CircularButton(label = part)
        }
    }
}