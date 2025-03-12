package com.example.burntrack.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burntrack.model.Exercise
import com.example.burntrack.model.ExercisesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed interface ExercisesUiState {
    data class Success(val exercises: List<Exercise>) : ExercisesUiState
    object Error : ExercisesUiState
    object Loading : ExercisesUiState
}

class ExercisesViewModel: ViewModel() {
    var exercisesUiState: ExercisesUiState by mutableStateOf(ExercisesUiState.Loading)
        private set


    fun getExercisesList(bodyPart: String) {
        viewModelScope.launch {
            var exercisesApi : ExercisesApi? = null
            try{
                delay(100)
                exercisesApi = ExercisesApi.getInstance()
                val exercises = ExercisesApi.getInstance().getExercises(bodyPart)
                exercisesUiState = ExercisesUiState.Success(exercises)
            } catch (e: Exception) {
                exercisesUiState = ExercisesUiState.Error
            }
        }
    }


}