package com.datnt.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class SideDishesFragment : Fragment() {
    private var viewModel: FoodViewModel? = null
    private var checkBox1: CheckBox? = null
    private var checkBox2: CheckBox? = null
    private var btnNext: Button? = null
    private var btnBack: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_side_dishes, container, false)

        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        checkBox1 = view?.findViewById(R.id.secondFood1)
        checkBox2 = view?.findViewById(R.id.secondFood2)
        btnNext = view?.findViewById(R.id.btnToDessert)
        btnBack = view?.findViewById(R.id.btnBackToMainDishes)

        checkBox1?.isChecked = viewModel?.getCheckBoxState(R.id.secondFood1) == true
        checkBox2?.isChecked = viewModel?.getCheckBoxState(R.id.secondFood2) == true

        checkBox1?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Bánh mì 2")
            }else{
                viewModel?.removeSelectedFood("Bánh mì 2")
            }
            viewModel?.setCheckBoxState(R.id.secondFood1, isChecked)
        }

        checkBox2?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Phở 2")
            }else{
                viewModel?.removeSelectedFood("Phở 2")
            }
            viewModel?.setCheckBoxState(R.id.secondFood2, isChecked)
        }

        btnNext?.setOnClickListener {
            findNavController().navigate(R.id.action_sideDishesFragment_to_dessertsFragment)
        }

        btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_sideDishesFragment_to_mainDishesFragment)
        }
        // Inflate the layout for this fragment
        return view
    }
}