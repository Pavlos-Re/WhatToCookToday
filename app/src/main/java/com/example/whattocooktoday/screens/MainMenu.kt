package com.example.whattocooktoday.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainMenu(navController: NavHostController) {

    Column {
        Text("!!!!!", modifier = Modifier.clickable { navController.navigate("RecipeView") })
    }

}