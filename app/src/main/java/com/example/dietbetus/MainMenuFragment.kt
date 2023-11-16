package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.dietbetus.databinding.FragmentMainMenuBinding


class MainMenuFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(layoutInflater)

        binding.continueFromMainMenuButton.setOnClickListener {
            var dagligtInsulin = binding.DailyInsulinIntakeText.text.toString().toInt()
            var longInsulin = binding.LongTimeInsulinText.text.toString().toInt()


        }
        return binding.root
    }
}