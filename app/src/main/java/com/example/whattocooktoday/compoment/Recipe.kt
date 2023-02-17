package com.example.whattocooktoday.compoment

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.whattocooktoday.screens.RecipeViewModel

@Composable
fun Recipe(viewModel: RecipeViewModel) {

    val recipe = viewModel.data.value.data?.toString()
    
    Text(text = "Hellooo")

    println("The result is: " + recipe)
}