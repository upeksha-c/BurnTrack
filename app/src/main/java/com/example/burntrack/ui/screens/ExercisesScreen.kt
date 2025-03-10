package com.example.burntrack.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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

            if (exercisesViewModel.isLoading.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier.size(50.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(
                            text = "Loading exercises...",
                            modifier = Modifier
                                .padding(8.dp),
                            color = MaterialTheme.colorScheme.onPrimary

                        )
                    }

                }
            } else {
                LazyColumn (
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp)
                ){
                    items(exercisesViewModel.exercises) { exercise ->
                        ExerciseCard(exercise)
                    }
                }

            }


    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 10.dp),
        elevation  = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ){
        Column (
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = exercise.name.toTitleFormat(),
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                )

            // Display the GIF image for the exercise
            GlideImage(
                imageModel = { exercise.gifUrl },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
            )

            //display instructions
            exercise.instructions.forEachIndexed { index,instruction ->
                Text(
                    text = "${index + 1}. $instruction",
                    modifier = Modifier.padding(top = 9.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

fun String.toTitleFormat(): String {
    val words = this.split(" ")
    val camelCaseString = words.joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
    return camelCaseString
}