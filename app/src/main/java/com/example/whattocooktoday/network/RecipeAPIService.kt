package com.example.whattocooktoday.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.spoonacular.com/"
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

private val retrofit = Retrofit.Builder()
    //.addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface RecipeAPIService {
    @GET("recipes/random?number=1&apiKey=3245166a97ab4292ae0ec30757763386")
    suspend fun getRecipe(): Recipe
    }
object RecipeApi {
    val retrofitService : RecipeAPIService by lazy {
        retrofit.create(RecipeAPIService::class.java)
    }
}
