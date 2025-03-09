package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.burntrack.model.Exercise
import com.example.burntrack.ui.components.ScreenTopAppBar
import com.example.burntrack.viewmodel.ExercisesViewModel

@Composable
fun ExercisesScreen(navController: NavController, modifier: Modifier = Modifier, bodyPart: String, exercisesViewModel : ExercisesViewModel = viewModel()){

    // Fetch exercises when the screen loads
    LaunchedEffect(bodyPart) {
        exercisesViewModel.getExercisesList(bodyPart)
    }

    Scaffold(
        topBar = {ScreenTopAppBar(bodyPart.uppercase(), navController)},
    ){innerPadding ->
        ExerciseCardList(modifier.padding(innerPadding), exercisesViewModel.exercises)
    }
}

@Composable
fun ExerciseCardList(modifier: Modifier = Modifier, exercises: List<Exercise>) {
    LazyColumn (
        modifier = modifier
            .padding(16.dp)
    ){
        items(exercises) { exercise ->
            Text(
                text = exercise.name,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}