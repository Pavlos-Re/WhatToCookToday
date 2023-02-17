package com.example.whattocooktoday.network

import com.example.whattocooktoday.data.Meal
import com.example.whattocooktoday.data.Request
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface RecipeApi {
    @GET("random.php")
    suspend fun getRecipe(): Request
}