package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentCalculateCarbsBinding

class CalculateCarbsFragment : Fragment() {

    private lateinit var binding: FragmentCalculateCarbsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateCarbsBinding.inflate(layoutInflater)
        binding.saveValuesCalculateCarbsButton.setOnClickListener {
            var baseInsuline = binding.baseInsulinText.text.toString().toInt()
            var dailyInsuline = binding.dailyInsulinText.text.toString().toInt()

            calculateCarbs(baseInsuline, dailyInsuline)
        }

        return binding.root
    }
    fun calculateCarbs(baseInsuline : Int, dailyInsuline : Int) {
        var result = 500 / (baseInsuline + dailyInsuline)
        binding.carbsResultText.text = "Baserat på ditt bas och dygnsinsulin så beräknas 1 insulin enhet hantera ${result} kolhydrater!"
    }
}