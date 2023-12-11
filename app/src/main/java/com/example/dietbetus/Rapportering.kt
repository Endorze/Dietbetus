package com.example.dietbetus

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dietbetus.databinding.FragmentRapporteringBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Rapportering : Fragment() {

    private lateinit var binding: FragmentRapporteringBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRapporteringBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.saveInsulinReportButton.setOnClickListener {
            val insulinAmount = binding.editTextInsulinInput.text.toString().toInt()
            saveInsulinTime(insulinAmount)
        }
        displayLatestSave()

        return binding.root
    }

    fun saveInsulinTime(text: Int) {

        val currentDateTimeMillis = System.currentTimeMillis()
        val preferences = requireActivity().getSharedPreferences("insulin_prefs", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt("insulin_amount", text)
        editor.putLong("report_time", currentDateTimeMillis)
        editor.apply()
        val savedInsulinAmount = preferences.getInt("insulin_amount", 0)
        val savedTime = preferences.getLong("report_time", 0)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val formattedDateTime = dateFormat.format(Date(savedTime))
        binding.latestInsulinTakenText.text = "Insulin taget: ${savedInsulinAmount}, tillfälle: ${formattedDateTime}"
    }
    fun displayLatestSave() {
        val preferences = requireActivity().getSharedPreferences("insulin_prefs", Context.MODE_PRIVATE)
        val lastInsulinTaken = preferences.getInt("insulin_amount", 0)
        val savedTime = preferences.getLong("report_time", 0)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val formattedDateTime = dateFormat.format(Date(savedTime))

        binding.latestInsulinTakenText.text = "Insulin taget: ${lastInsulinTaken}, tillfälle: ${formattedDateTime}"
    }
}