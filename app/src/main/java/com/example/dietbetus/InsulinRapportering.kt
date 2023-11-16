package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentInsulinRapporteringBinding

class InsulinRapportering : Fragment() {

    private lateinit var binding: FragmentInsulinRapporteringBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsulinRapporteringBinding.inflate(layoutInflater)




        // Inflate the layout for this fragment
        return binding.root
    }

}