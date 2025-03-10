package com.example.burntrack.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burntrack.model.Exercise
import com.example.burntrack.model.ExercisesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExercisesViewModel: ViewModel() {
    var exercises = mutableStateListOf<Exercise>()
        private set

    var isLoading = mutableStateOf(false)

    fun getExercisesList(bodyPart: String) {
        viewModelScope.launch {
            var exercisesApi : ExercisesApi? = null
            try{
                isLoading.value = true
                delay(100)
                exercisesApi = ExercisesApi.getInstance()
                exercises.clear()
                exercises.addAll(exercisesApi.getExercises(bodyPart))
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
            }finally {
                isLoading.value = false
            }
        }
    }


}