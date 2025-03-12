package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burntrack.R

@Composable
fun ErrorScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 35.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.error),
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}