package com.example.burntrack.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burntrack.api.BodyPartsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BodyPartViewModel: ViewModel() {
    var bodyParts = mutableStateListOf<String>()
        private set

    var isLoading = mutableStateOf(false)
    init {
        getBodyPartsList()
    }
    private fun getBodyPartsList(){
        viewModelScope.launch {
            var bodyPartApi : BodyPartsApi? = null
            try {
                isLoading.value = true
                delay(100)
                bodyPartApi = BodyPartsApi.getInstance()
                bodyParts.clear()
                bodyParts.addAll(bodyPartApi.getBodyPartList())
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
            }finally {
                isLoading.value = false
            }
        }
    }
}