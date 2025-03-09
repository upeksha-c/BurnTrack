package com.example.burntrack.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.burntrack.model.Exercise
import com.example.burntrack.ui.components.ScreenTopAppBar
import com.example.burntrack.viewmodel.ExercisesViewModel
import com.skydoves.landscapist.glide.GlideImage

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
                text = exercise.name.toTitleFormat(),
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            // Display the GIF image for the exercise
            GlideImage(
                imageModel = { exercise.gifUrl },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )

            //display instructions
            exercise.instructions.forEachIndexed() { index,instruction ->
                Text(
                    text = "${index + 1}. $instruction",
                    modifier = Modifier.padding(top = 9.dp)
                )
            }
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
        }
    }
}

fun String.toTitleFormat(): String {
    val words = this.split(" ")
    val camelCaseString = words.joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
    return camelCaseString
}