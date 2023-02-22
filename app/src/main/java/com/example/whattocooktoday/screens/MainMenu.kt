package com.example.whattocooktoday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.whattocooktoday.functions.makeIngredientsList
import com.example.whattocooktoday.functions.makeMeasureList

@Composable
fun MainMenu(recipeViewModel: ViewModelScreen = viewModel()) {

    val recipeUiState by recipeViewModel.uiState.collectAsState()

    val recipe = recipeUiState.curRecipe

    if (recipe != null) {

        val ingredients = makeIngredientsList(recipe)
        val measures = makeMeasureList(recipe)
        
        Image(
            painter = painterResource(id = com.example.whattocooktoday.R.drawable.kitchen),
            contentDescription = "Background Picture",contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize())

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Cuisine: " + recipe.strArea, modifier = Modifier.padding(5.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))

                Text(text = recipe.strMeal, modifier = Modifier.padding(5.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
            }

            val str = recipe.strMealThumb

            AsyncImage(model = str, contentDescription = "Meal image")

            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .background(Color(0xfffae1a9)),
            ) {

                val lazyListState = rememberLazyListState()

                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xfffae1a9))
                    .padding(15.dp)
                    , lazyListState) {
                    item {

                        Text(text = recipe.strInstructions, modifier = Modifier.padding(5.dp))

                        Text(text = "Ingredients: ", modifier = Modifier.padding(5.dp))

                    }
                    items(ingredients.size) {
                        if (ingredients[it].isNotEmpty() && ingredients[it] != "null") {
                            Text("${it + 1}) " + measures[it] + " " + ingredients[it])
                        }
                    }
                }
            }
        }
    }
}
