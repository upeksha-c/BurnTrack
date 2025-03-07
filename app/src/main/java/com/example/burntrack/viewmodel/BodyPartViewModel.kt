package com.example.burntrack.viewmodel

import androidx.lifecycle.ViewModel

class BodyPartViewModel: ViewModel() {
    val bodyParts = mutableListOf<String>()
    init {
        bodyParts.add("Arms")
        bodyParts.add("Legs")
        bodyParts.add("Belly")
    }
}