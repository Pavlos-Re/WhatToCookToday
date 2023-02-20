package com.example.whattocooktoday.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val num = 1

private const val BASE_URL = "https:/www.themealdb.com/api/json/v1/${num}"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

private val retrofit = Retrofit.Builder()
    //.addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface RecipeAPIService {
    @GET("/random.php")
    suspend fun getRecipe(): Meal
    }
object RecipeApi {
    val retrofitService : RecipeAPIService by lazy {
        retrofit.create(RecipeAPIService::class.java)
    }
}
