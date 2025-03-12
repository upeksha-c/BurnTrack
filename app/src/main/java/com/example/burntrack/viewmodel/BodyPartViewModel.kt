package com.example.burntrack.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.burntrack.api.BodyPartsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed interface BodyPartUiState {
    data class Success(val bodyParts: List<String>) : BodyPartUiState
    object Error : BodyPartUiState
    object Loading : BodyPartUiState
}

class BodyPartViewModel: ViewModel() {
    var bodyPartUiState: BodyPartUiState by mutableStateOf(BodyPartUiState.Loading)

        private set

    init {
        getBodyPartsList()
    }
    private fun getBodyPartsList(){
        viewModelScope.launch {
            var bodyPartApi : BodyPartsApi? = null
            try {
                delay(100)
                bodyPartApi = BodyPartsApi.getInstance()
                //bodyParts.clear()
                //bodyParts.addAll(bodyPartApi.getBodyPartList())
                //bodyPartUiState = BodyPartUiState.Success(bodyPartApi.getBodyPartList())
                val bodyParts = BodyPartsApi.getInstance().getBodyPartList()

                if (bodyParts.isNotEmpty()) {
                    bodyPartUiState = BodyPartUiState.Success(bodyParts)
                } else {
                    bodyPartUiState = BodyPartUiState.Error
                }
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
                bodyPartUiState = BodyPartUiState.Error
            }
        }
    }
}