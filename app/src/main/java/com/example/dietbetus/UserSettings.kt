package com.example.dietbetus

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentUsersettingsBinding

class UserSettings : Fragment() {

    private lateinit var binding: FragmentUsersettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersettingsBinding.inflate(layoutInflater)

        if (binding.darkmodeSwitch.isChecked) {
            requireActivity().application.setTheme(R.style.AppTheme_Dark)

            requireActivity().recreate()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}