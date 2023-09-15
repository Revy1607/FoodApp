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


class DessertsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_desserts, container, false)

        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        checkBox1 = view?.findViewById(R.id.desserts1)
        checkBox2 = view?.findViewById(R.id.desserts2)
        btnNext = view?.findViewById(R.id.btnToDrink)
        btnBack = view?.findViewById(R.id.btnBackToSideDishes)

        checkBox1?.isChecked = viewModel?.getCheckBoxState(R.id.desserts1) == true
        checkBox2?.isChecked = viewModel?.getCheckBoxState(R.id.desserts2) == true

        checkBox1?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Bánh mì 3")
            }else{
                viewModel?.removeSelectedFood("Bánh mì 3")
            }
            viewModel?.setCheckBoxState(R.id.desserts1, isChecked)
        }

        checkBox2?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Phở 3")
            }else{
                viewModel?.removeSelectedFood("Phở 3")
            }
            viewModel?.setCheckBoxState(R.id.desserts2, isChecked)
        }

        btnNext?.setOnClickListener {
            findNavController().navigate(R.id.action_dessertsFragment_to_drinksFragment)
        }

        btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_dessertsFragment_to_sideDishesFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

}