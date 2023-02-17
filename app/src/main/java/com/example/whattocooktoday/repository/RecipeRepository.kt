package com.example.whattocooktoday.repository

import android.util.Log
import com.example.whattocooktoday.data.Meal
import com.example.whattocooktoday.data.RecipeOrException
import com.example.whattocooktoday.network.RecipeApi
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeApi
) {
    private val recipeOrException =
        RecipeOrException<List<Meal>,
                Boolean,
                Exception>()

    suspend fun getRecipe(): RecipeOrException<List<Meal>, Boolean, java.lang.Exception> {
        try {
            recipeOrException.loading = true
            recipeOrException.data = api.getRecipe()
            if (recipeOrException.data.toString().isNotEmpty()) recipeOrException.loading = false

        } catch (exception: Exception) {
            recipeOrException.e = exception

        }
        return recipeOrException
    }
}
