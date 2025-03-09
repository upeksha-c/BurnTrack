package com.example.burntrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CircularButton(label: String, navController: NavController){
    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(Color.DarkGray)
            .clickable { navController.navigate(("matching_result")) }
            .border(
                5.dp,
                Color.Yellow,
                CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Icon(
                Icons.Default.Star,
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = label,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}