package com.example.whattocooktoday.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattocooktoday.data.Meal
import com.example.whattocooktoday.data.RecipeOrException
import com.example.whattocooktoday.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel  @Inject constructor(private val repository: RecipeRepository)
    : ViewModel() {
        val data: MutableState<RecipeOrException<List<Meal>,
                Boolean, Exception>> = mutableStateOf(
                RecipeOrException(null, true, Exception(""))
                )

    init {
        getRecipe()
    }

    private fun getRecipe() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getRecipe()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }

    }