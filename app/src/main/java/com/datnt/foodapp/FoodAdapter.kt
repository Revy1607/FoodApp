package com.datnt.foodapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FoodAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> MainDishesFragment()
            1 -> SideDishesFragment()
            2 -> DessertsFragment()
            3 -> DrinksFragment()
            4 -> ListFood()
            else -> MainDishesFragment()
        }
    }
}