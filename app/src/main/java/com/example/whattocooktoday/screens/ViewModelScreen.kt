package com.example.whattocooktoday.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattocooktoday.data.RecipeApi
import kotlinx.coroutines.launch

class ViewModelScreen: ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getRecipe()
    }

    private fun getRecipe() {
        viewModelScope.launch {
            try {
                val listResult = RecipeApi.retrofitService.getRecipe()
                _status.value = listResult.size.toString()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}