package com.example.burntrack.viewmodel

import androidx.lifecycle.ViewModel

class ExercisesViewModel: ViewModel() {
    val exercises = mutableListOf<String>()

    init {
        exercises.add("Test 1")
        exercises.add("Test 2")
        exercises.add("Test 3")
        exercises.add("Test 4")
        exercises.add("Test 5")
    }
}