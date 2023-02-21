package com.example.whattocooktoday.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RecipeAPIService {
    @GET("random.php")
    suspend fun getRecipe(): Recipe

    }

object RecipeApi {
    val retrofitService : RecipeAPIService by lazy {
        retrofit.create(RecipeAPIService::class.java)
    }
}
