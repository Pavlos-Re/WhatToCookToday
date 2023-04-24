package com.example.whattocooktoday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.whattocooktoday.data.MealDomain
import com.example.whattocooktoday.data.RecipeApi
import com.example.whattocooktoday.data.RecipeUiState
import kotlinx.coroutines.launch

@Composable
fun MainMenu(recipeViewModel: ViewModelScreen = viewModel()) {

    val recipeUiState by recipeViewModel.uiState.collectAsState()

    val recipe = recipeUiState.curRecipe

    Background()
    if (recipe != null) {
        Foreground(
            recipe = recipe,
            recipeViewModel
        )
    }

}

@Composable
fun Foreground(
    recipe: MealDomain = MealDomain.default(),
    recipeViewModel: ViewModelScreen
) {

    var area by remember {mutableStateOf(  recipe.area) }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Cuisine: $area",
                    color = Color.Black,
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Image(
                    painter = painterResource(id =  com.example.whattocooktoday.R.drawable.new_recipe),
                    contentDescription = "New Recipe",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            recipeViewModel.viewModelScope.launch {
                                var state: RecipeUiState? = null
                                try {
                                    val listResult = RecipeApi.retrofitService.getRecipe()
                                    state = RecipeUiState(listResult.meals[0].toDomain())
                                    println("The result is: " + state.curRecipe!!.meal)

                                    area = state.curRecipe!!.area
                                    recipe.meal = state.curRecipe!!.meal
                                    recipe.thumb = state.curRecipe!!.thumb
                                    recipe.ingredients = state.curRecipe!!.ingredients
                                    recipe.measures = state.curRecipe!!.measures
                                    recipe.instructions = state.curRecipe!!.instructions
                                    recipe.category = state.curRecipe!!.category

                                    //println("The result: " + area + " ++ " + recipe.meal)
                                // recipe = state.curRecipe!!

                                } catch (e: Exception) {
                                    //_uiState.value = RecipeUiState(${e.message})
                                    println("The result is ++++++++++ ${e.message}")

                                }
                            }
                        }
                )
            }
            Text(text = recipe.meal,
                modifier = Modifier.padding(5.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        }

        val str = recipe.thumb

        AsyncImage(model = str, contentDescription = "Meal image", modifier = Modifier.border(5.dp, Color.Black, RoundedCornerShape(5.dp)))

        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
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
            .padding(10.dp),
            lazyListState
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

        Text("${it + 1}) " + recipe.measures[it] + " " + recipe.ingredients[it], color = Color.Black)

}

@Composable
private fun RecipeDescription(recipe: MealDomain = MealDomain.default()) {
    Text(text = recipe.instructions, color = Color.Black,
        modifier = Modifier.padding(5.dp))

    Text(text = "Ingredients: ", color = Color.Black,
        modifier = Modifier.padding(5.dp),
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)

    )
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
