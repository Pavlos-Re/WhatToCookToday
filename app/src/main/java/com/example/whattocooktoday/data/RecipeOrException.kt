package com.example.whattocooktoday.data

data class RecipeOrException<T, Boolean, E: java.lang.Exception> (
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
        )