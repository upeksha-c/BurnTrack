package com.example.burntrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CircularButton(label: String, navController: NavController){
    Box(
        modifier = Modifier
            //.size(90.dp)
            .height(50.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable { navController.navigate(("exercises_screen/$label")) }
            .border(
                width = 5.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(25.dp)
            )
            .shadow(
                elevation = 20.dp,
            ),
        contentAlignment = Alignment.Center
    ) {
            Text(
                text = label.uppercase(),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 18.sp
            )
    }
}