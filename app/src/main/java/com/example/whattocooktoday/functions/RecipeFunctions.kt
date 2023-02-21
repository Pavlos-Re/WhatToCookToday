package com.example.whattocooktoday.functions

import com.example.whattocooktoday.data.Meal


fun makeIngredientsList(recipe: Meal?): MutableList<String> {

    val ingredients : MutableList<String> = emptyList<String>().toMutableList()

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

    return ingredients

}

fun makeMeasureList(recipe: Meal?): MutableList<String> {

    val measures : MutableList<String> = emptyList<String>().toMutableList()

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

    return measures

}
