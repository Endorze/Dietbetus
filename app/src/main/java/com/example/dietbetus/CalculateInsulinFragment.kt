package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentCalculateInsulinBinding


class CalculateInsulinFragment : Fragment() {

    private lateinit var binding: FragmentCalculateInsulinBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateInsulinBinding.inflate(layoutInflater)

        binding.saveValuesCalculateInsulineButton.setOnClickListener {
            var baseInsuline = binding.baseInsulinText.text.toString().toInt()
            var dailyInsuline = binding.dailyInsulinText.text.toString().toInt()
            calculateInsulinSensitivity(baseInsuline, dailyInsuline)
        }

        return binding.root
    }
    fun calculateInsulinSensitivity(baseInsuline : Int, dailyInsuline : Int) {
        var result = 100 / (baseInsuline + dailyInsuline)
        binding.carbsResultText.text = "Baserat på ditt bas och dygnsinsulin så beräknas 1 insulin enhet att sänka ditt blodsocker med ${result}/mmol/l!"
    }
}