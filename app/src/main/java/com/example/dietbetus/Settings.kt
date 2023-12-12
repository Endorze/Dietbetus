package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentSettingsBinding


class Settings : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)


        if (binding.darkmodeSwitch.isChecked) {
            requireActivity().application.setTheme(R.style.AppTheme_Dark)
            requireActivity().recreate()
        }


        // Inflate the layout for this fragment
        return binding.root
    }
}