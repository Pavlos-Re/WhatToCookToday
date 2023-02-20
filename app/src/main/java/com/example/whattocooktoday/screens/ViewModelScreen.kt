package com.example.whattocooktoday.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattocooktoday.data.RecipeApi
import com.example.whattocooktoday.data.RecipeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelScreen: ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())

    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    init {
        getRecipe()
    }

    private fun getRecipe() {
        viewModelScope.launch {
            try {
                val listResult = RecipeApi.retrofitService.getRecipe()
                _uiState.value = RecipeUiState(listResult[0].sourceName)
            } catch (e: Exception) {
                _uiState.value = RecipeUiState("${e.message}")
            }
        }
    }
}