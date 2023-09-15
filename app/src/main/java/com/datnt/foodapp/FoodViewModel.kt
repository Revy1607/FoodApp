package com.datnt.foodapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel : ViewModel() {
    private val selectedFoods = MutableLiveData<List<String>>()
    private val checkBoxStates = mutableMapOf<Int, Boolean>()

    //xử lý sự kiện check box: không bị mất trạng thái khi chuyển sang màn khác
    fun getCheckBoxState(checkBoxId: Int): Boolean {
        return checkBoxStates[checkBoxId] ?: false
    }

    fun setCheckBoxState(checkBoxId: Int, isChecked: Boolean) {
        checkBoxStates[checkBoxId] = isChecked
    }

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
