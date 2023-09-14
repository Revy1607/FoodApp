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


class DrinksFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_drinks, container, false)

        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        checkBox1 = view?.findViewById(R.id.drink1)
        checkBox2 = view?.findViewById(R.id.drink2)
        btnNext = view?.findViewById(R.id.btnToListFood)
        btnBack = view?.findViewById(R.id.btnBackToDessert)

        checkBox1?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Trà đá")
            }else{
                viewModel?.removeSelectedFood("Trà đá")
            }
        }

        checkBox2?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Cà phê")
            }else{
                viewModel?.removeSelectedFood("Cà phê")
            }
        }

        btnNext?.setOnClickListener {
            findNavController().navigate(R.id.action_drinksFragment_to_listFood)
        }

        btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_drinksFragment_to_dessertsFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

}