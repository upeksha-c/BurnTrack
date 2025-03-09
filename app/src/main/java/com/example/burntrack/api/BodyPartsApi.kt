package com.example.burntrack.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

const val BASE_URL = "https://exercisedb.p.rapidapi.com/exercises/"

interface BodyPartsApi {
    @Headers(
        "X-RapidAPI-Key: 5a84c1220fmsh3675406138a814ep171340jsne32ff6d7ed7d"
    )

    @GET("bodyPartList")
    suspend fun getBodyPartList(): List<String>

    companion object{
        var bodyPartApiService: BodyPartsApi? = null

        fun getInstance(): BodyPartsApi{
            if (bodyPartApiService === null) {
                bodyPartApiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(BodyPartsApi::class.java)
            }
            return bodyPartApiService!!
        }
    }
}