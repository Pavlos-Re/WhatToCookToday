package com.example.whattocooktoday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.whattocooktoday.screens.MainMenu
import com.example.whattocooktoday.screens.RecipeView


@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainMenu") {
        composable("MainMenu") { MainMenu(navController) }
        composable("RecipeView") { RecipeView(navController)}

    }

}
