package com.datnt.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController


class ListFood : Fragment() {
    private var viewModel: FoodViewModel? = null
    private var tv: TextView? = null
    private var btnBack: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_food, container, false)
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        tv = view?.findViewById(R.id.tv)
        btnBack = view?.findViewById(R.id.btnBack)

       viewModel?.getSelectedFoods()?.observe(viewLifecycleOwner, Observer { selectedFoods ->
           tv?.text = selectedFoods.joinToString(", ")
       })

        btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_listFood_to_drinksFragment)
        }
        return view
    }

}