package com.example.whattocooktoday.data

data class MealDomain(
    var instructions: String,
    var area: String,
    var meal: String,
    var thumb: String?,
    var category: String,
    var ingredients: List<String>,
    var measures: List<String>,
    ) {
        companion object {
                 fun default() = MealDomain(
                        meal = "No meal",
                        category = "No category",
                        area = "No area",
                        instructions = "No instructions",
                        thumb = "No thumb",
                        ingredients = listOf("No ingredients"),
                        measures = listOf("No measures"),
                    )
            }
    }
