package com.example.whattocooktoday.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.whattocooktoday.compoment.Recipe
import com.example.whattocooktoday.data.Meal
import com.example.whattocooktoday.data.Request
import com.example.whattocooktoday.network.ApiClient
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


@Composable
fun MainMenu( viewModel: RecipeViewModel = hiltViewModel()) =  Recipe(viewModel)


