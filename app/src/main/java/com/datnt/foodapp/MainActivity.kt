package com.datnt.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val bnvHome = findViewById<BottomNavigationView>(R.id.bnvHome)
//        val viewPage = findViewById<ViewPager2>(R.id.viewPager)
//        val adapter = FoodAdapter(this)
//        viewPage.adapter = adapter
//        //disable swipe
//        viewPage.isUserInputEnabled = false
//
//        bnvHome.setOnItemSelectedListener {
//            if(it.itemId == R.id.MainDishes){
//                viewPage.currentItem = 0
//            }else if(it.itemId == R.id.SideDishes){
//                viewPage.currentItem = 1
//            }else if(it.itemId == R.id.Desserts){
//                viewPage.currentItem = 2
//            }else if(it.itemId == R.id.Drinks){
//                viewPage.currentItem = 3
//            }else if(it.itemId == R.id.ListFood){
//                viewPage.currentItem = 4
//            }else{
//                viewPage.currentItem = 5
//            }
//            return@setOnItemSelectedListener true
//        }
    }
}