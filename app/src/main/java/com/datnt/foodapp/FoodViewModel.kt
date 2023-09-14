package com.datnt.foodapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel : ViewModel() {
    private val selectedFoods = MutableLiveData<List<String>>()

    fun getSelectedFoods(): LiveData<List<String>> {
        return selectedFoods
    }

    fun addSelectedFood(food: String) {
        val currentList = selectedFoods.value?.toMutableList() ?: mutableListOf()
        currentList.add(food)
        selectedFoods.value = currentList

    }

    fun removeSelectedFood(food: String) {
        val currentList = selectedFoods.value?.toMutableList() ?: mutableListOf()
        currentList.remove(food)
        selectedFoods.value = currentList

    }
}
