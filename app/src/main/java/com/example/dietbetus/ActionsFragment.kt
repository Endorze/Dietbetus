package com.example.dietbetus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.dietbetus.databinding.FragmentActionsBinding
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.navigation.Navigation


class ActionsFragment : Fragment() {
    private lateinit var binding: FragmentActionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActionsBinding.inflate(layoutInflater)

        var spinner: Spinner = binding.spinnerActionFragment

        val context = this.context
        getActionBar

        if (context == null) {
            parentFragmentManager.popBackStack()
            return null
        }

        val adapter = ArrayAdapter.createFromResource(
            context,
            R.array.ActionFragmentOptions,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedOption = parent?.getItemAtPosition(position).toString()
                when (selectedOption) {
                    "Insulin Rapportering" -> {
                        val action =
                            ActionsFragmentDirections.actionActionsFragmentToInsulinRapportering()
                        Navigation.findNavController(binding.root).navigate(action)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return binding.root
    }
}