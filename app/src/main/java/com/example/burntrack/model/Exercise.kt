package com.example.burntrack.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

data class Exercise(
    var bodyPart: String,
    var equipment: String,
    var gifUrl: String,
    var id: String,
    var name: String,
    var target: String,
    var secondaryMuscles: List<String>,
    var instructions: List<String>
)

// Base URL for the API service
const val BASE_URL = "https://exercisedb.p.rapidapi.com"

// Retrofit interface to define API endpoints
interface ExercisesApi {
    @Headers("X-RapidAPI-Key: 5a84c1220fmsh3675406138a814ep171340jsne32ff6d7ed7d")
    @GET("exercises/bodyPart/{bodyPart}")
    suspend fun getExercises(
        @retrofit2.http.Path("bodyPart") bodyPart: String,
        @retrofit2.http.Query("limit") limit: Int = 10,
        @retrofit2.http.Query("offset") offset: Int = 0
    ) : List<Exercise>

    companion object {
        var exercisesService: ExercisesApi? = null

        fun getInstance(): ExercisesApi {
            if (exercisesService ===null) {
                exercisesService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ExercisesApi::class.java)
            }
            return exercisesService!!
        }
    }
}