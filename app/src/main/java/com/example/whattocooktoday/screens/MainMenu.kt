package com.example.whattocooktoday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.whattocooktoday.data.MealDomain

@Composable
fun MainMenu(recipeViewModel: ViewModelScreen = viewModel()) {

    val recipeUiState by recipeViewModel.uiState.collectAsState()

    val recipe = recipeUiState.curRecipe

    if (recipe != null) {
                Background()
                Foreground(
                        recipe = recipe,
                    )
            }

}

@Composable
fun Foreground(recipe: MealDomain = MealDomain.default()) {

    //val ingredients = makeIngredientsList(recipe)
    //val measures = makeMeasureList(recipe)

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color(0xffe3934c)
        )) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = "Cuisine: " + recipe.area,
                color = Color.Black,
                modifier = Modifier.padding(5.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))

            Text(text = recipe.meal, modifier = Modifier.padding(5.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        }

        val str = recipe.thumb

        AsyncImage(model = str, contentDescription = "Meal image")

        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color(0xfffae1a9)),
        ) {

            Recipe(recipe)

        }

    }
}

@Composable
private fun Recipe(recipe: MealDomain = MealDomain.default()) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xfffae1a9))
            .padding(end = 10.dp), lazyListState
    ) {

        item {

            RecipeDescription(recipe)

        }

        items(recipe.ingredients.size) {
            RecipeIngredients(it, recipe)
        }

    }
}

@Composable
private fun RecipeIngredients(it: Int, recipe: MealDomain = MealDomain.default()) {

        Text("${it + 1}) " + recipe.measures[it] + " " + recipe.ingredients[it])

}

@Composable
private fun RecipeDescription(recipe: MealDomain = MealDomain.default()) {
    Text(text = recipe.instructions, color = Color.Black, modifier = Modifier.padding(5.dp))

    Text(text = "Ingredients: ", color = Color.Black, modifier = Modifier.padding(5.dp))
}

@Composable
private fun Background() {
        Image(
                painter = painterResource(id = com.example.whattocooktoday.R.drawable.kitchen),
                contentDescription = "Background Picture",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
                )
    }
