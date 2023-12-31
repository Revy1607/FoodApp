package com.datnt.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class MainDishesFragment : Fragment() {
    private var viewModel: FoodViewModel? = null
    private var checkBox1: CheckBox? = null
    private var checkBox2: CheckBox? = null
    private var btnNext: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_dishes, container, false)
        // Khởi tạo ViewModel
        viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]

        checkBox1 = view?.findViewById(R.id.food1)
        checkBox2 = view?.findViewById(R.id.food2)
        btnNext = view?.findViewById(R.id.btnToSideDishes)

        // Lấy trạng thái từ ViewModel và đặt cho CheckBox
        checkBox1?.isChecked = viewModel?.getCheckBoxState(R.id.food1) == true
        checkBox2?.isChecked = viewModel?.getCheckBoxState(R.id.food2) == true

        checkBox1?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Bánh mì")
            }else{
                viewModel?.removeSelectedFood("Bánh mì")
            }
            // Lưu trạng thái CheckBox vào ViewModel
            viewModel?.setCheckBoxState(R.id.food1, isChecked)
        }

        checkBox2?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel?.addSelectedFood("Phở")
            }else{
                viewModel?.removeSelectedFood("Phở")
            }
            viewModel?.setCheckBoxState(R.id.food2, isChecked)
        }

        btnNext?.setOnClickListener {
            findNavController().navigate(R.id.action_mainDishesFragment_to_sideDishesFragment)
        }

        return view
    }


}

