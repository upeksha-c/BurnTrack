package com.example.burntrack.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun AppTitle(){
    Text(
        text = "BurnTrack",
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
    )
    Text(
        text = "Find your move, master your routine",
        fontSize = 9.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .fillMaxWidth()
    )
}