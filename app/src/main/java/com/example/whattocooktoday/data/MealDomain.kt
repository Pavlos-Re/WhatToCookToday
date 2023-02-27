package com.example.whattocooktoday.data

data class MealDomain(
        val instructions: String,
        val area: String,
        val meal: String,
        val thumb: String?,
        val category: String,
        val ingredients: List<String>,
        val measures: List<String>,
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
