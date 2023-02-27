package com.example.whattocooktoday.data

import com.squareup.moshi.Json

data class Meal(
    @Json(name = "strInstructions") val strInstructions: String,
    @Json(name = "strArea") val strArea: String,
    @Json(name = "strMeal") val strMeal: String,
    @Json(name = "strCategory") val strCategory: String,
    @Json(name = "strIngredient1") val strIngredient1: String?,
    @Json(name = "strIngredient10") val strIngredient10: String?,
    @Json(name = "strIngredient11") val strIngredient11: String?,
    @Json(name = "strIngredient12") val strIngredient12: String?,
    @Json(name = "strIngredient13") val strIngredient13: String?,
    @Json(name = "strIngredient14") val strIngredient14: String?,
    @Json(name = "strIngredient15") val strIngredient15: String?,
    @Json(name = "strIngredient16") val strIngredient16: String?,
    @Json(name = "strIngredient17") val strIngredient17: String?,
    @Json(name = "strIngredient18") val strIngredient18: String?,
    @Json(name = "strIngredient19") val strIngredient19: String?,
    @Json(name = "strIngredient2") val strIngredient2: String?,
    @Json(name = "strIngredient20") val strIngredient20: String?,
    @Json(name = "strIngredient3") val strIngredient3: String?,
    @Json(name = "strIngredient4") val strIngredient4: String?,
    @Json(name = "strIngredient5") val strIngredient5: String?,
    @Json(name = "strIngredient6") val strIngredient6: String?,
    @Json(name = "strIngredient7") val strIngredient7: String?,
    @Json(name = "strIngredient8") val strIngredient8: String?,
    @Json(name = "strIngredient9") val strIngredient9: String?,
    @Json(name = "strMealThumb") val strMealThumb: String?,
    @Json(name = "strMeasure1") val strMeasure1: String?,
    @Json(name = "strMeasure10") val strMeasure10: String?,
    @Json(name = "strMeasure11") val strMeasure11: String?,
    @Json(name = "strMeasure12") val strMeasure12: String?,
    @Json(name = "strMeasure13") val strMeasure13: String?,
    @Json(name = "strMeasure14") val strMeasure14: String?,
    @Json(name = "strMeasure15") val strMeasure15: String?,
    @Json(name = "strMeasure16") val strMeasure16: String?,
    @Json(name = "strMeasure17") val strMeasure17: String?,
    @Json(name = "strMeasure18") val strMeasure18: String?,
    @Json(name = "strMeasure19") val strMeasure19: String?,
    @Json(name = "strMeasure2") val strMeasure2: String?,
    @Json(name = "strMeasure20") val strMeasure20: String?,
    @Json(name = "strMeasure3") val strMeasure3: String?,
    @Json(name = "strMeasure4") val strMeasure4: String?,
    @Json(name = "strMeasure5") val strMeasure5: String?,
    @Json(name = "strMeasure6") val strMeasure6: String?,
    @Json(name = "strMeasure7") val strMeasure7: String?,
    @Json(name = "strMeasure8") val strMeasure8: String?,
    @Json(name = "strMeasure9") val strMeasure9: String?,

) {

    fun toDomain() = MealDomain(
        instructions = strInstructions,
        area = strArea,
        meal = strMeal,
        thumb = strMealThumb,
        category = strCategory,
        ingredients = makeIngredientsList(this),
        measures = makeMeasureList(this)
    )
}
    fun makeIngredientsList(recipe: Meal?): List<String> {
        val ingredients: MutableList<String> = emptyList<String>().toMutableList()
        if (recipe != null) {
            ingredients.add(recipe.strIngredient1.toString())
            ingredients.add(recipe.strIngredient2.toString())
            ingredients.add(recipe.strIngredient3.toString())
            ingredients.add(recipe.strIngredient4.toString())
            ingredients.add(recipe.strIngredient5.toString())
            ingredients.add(recipe.strIngredient6.toString())
            ingredients.add(recipe.strIngredient7.toString())
            ingredients.add(recipe.strIngredient8.toString())
            ingredients.add(recipe.strIngredient9.toString())
            ingredients.add(recipe.strIngredient10.toString())
            ingredients.add(recipe.strIngredient11.toString())
            ingredients.add(recipe.strIngredient12.toString())
            ingredients.add(recipe.strIngredient13.toString())
            ingredients.add(recipe.strIngredient14.toString())
            ingredients.add(recipe.strIngredient15.toString())
            ingredients.add(recipe.strIngredient16.toString())
            ingredients.add(recipe.strIngredient17.toString())
            ingredients.add(recipe.strIngredient18.toString())
            ingredients.add(recipe.strIngredient19.toString())
            ingredients.add(recipe.strIngredient20.toString())

        }
        return ingredients.filter { it.isNotEmpty() && it != "null" } as MutableList<String>
    }

    fun makeMeasureList(recipe: Meal?): List<String> {
        val measures: MutableList<String> = emptyList<String>().toMutableList()
        if (recipe != null) {
            measures.add(recipe.strMeasure1.toString())
            measures.add(recipe.strMeasure2.toString())
            measures.add(recipe.strMeasure3.toString())
            measures.add(recipe.strMeasure4.toString())
            measures.add(recipe.strMeasure5.toString())
            measures.add(recipe.strMeasure6.toString())
            measures.add(recipe.strMeasure7.toString())
            measures.add(recipe.strMeasure8.toString())
            measures.add(recipe.strMeasure9.toString())
            measures.add(recipe.strMeasure10.toString())
            measures.add(recipe.strMeasure11.toString())
            measures.add(recipe.strMeasure12.toString())
            measures.add(recipe.strMeasure13.toString())
            measures.add(recipe.strMeasure14.toString())
            measures.add(recipe.strMeasure15.toString())
            measures.add(recipe.strMeasure16.toString())
            measures.add(recipe.strMeasure17.toString())
            measures.add(recipe.strMeasure18.toString())
            measures.add(recipe.strMeasure19.toString())
            measures.add(recipe.strMeasure20.toString())
        }
        return measures.filter { it.isNotEmpty() && it != "null" } as MutableList<String>
    }
