package com.example.whattocooktoday.data

import com.squareup.moshi.Json

data class RecipeUiState (
    val curRecipe : String?
    //@Json(name = "title") val titleRe: String?
        )