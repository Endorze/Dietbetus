package com.example.dietbetus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.isVisible
import com.example.dietbetus.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private lateinit var binding: FragmentRecipesBinding
    private lateinit var selectedRecipe: Dish
    private lateinit var portionSize: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentRecipesBinding.inflate(layoutInflater)

        val recipeSpinner: Spinner = binding.spinnerChooseFood
        val portionSpinner: Spinner = binding.spinnerChooseSize
        val context = this.context
        if (context == null) {
            parentFragmentManager.popBackStack()
            return null
        }
        val dishAdapter : ArrayAdapter<Dish> = ArrayAdapter(context, android.R.layout.simple_spinner_item, Dish.values())

        val portionAdapter = ArrayAdapter.createFromResource(
            context,
            R.array.portionSizes,
            android.R.layout.simple_spinner_item
        )
        portionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        portionSpinner.adapter = portionAdapter

        dishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        recipeSpinner.adapter = dishAdapter

        portionSize = "1 Portion"

        recipeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedRecipe = Dish.values()[position]
                binding.recipeText.text = "Du har valt ${selectedRecipe.dishName}"
                    Log.i("RecipesFragment", "Innan bilden ska laddas in")
                    binding.foodImage.setImageResource(selectedRecipe.photo)
                    Log.i("RecipesFragment", "Efter bilden ska ha laddats in")
                    updateCalories(selectedRecipe, portionSize)

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.recipeText.text = ""
            }
        }
        portionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                portionSize = parent?.getItemAtPosition(position).toString()
                binding.portionText.text = "${portionSize}"
                updateCalories(selectedRecipe, portionSize)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.portionText.text = ""
            }
        }
        return binding.root
    }

    private fun updateCalories(recipe: Dish, portionSize: String) {
        if (!::portionSize.isInitialized) {
            // Låt användaren välja en portionsstorlek först
            return
        }
        val noPortions: Int = when {
            portionSize == "1 Portion" -> 1
            portionSize == "2 Portioner" -> 2
            portionSize == "3 Portioner" -> 3
            else -> 0
        }

        val calories = recipe.getCaloriesPerPortion();
        val kolhydrater = recipe.getCarbonhydratesPerPortion()
        val portionWeight = recipe.portionSize

        binding.caloriesText.text = "${calories * noPortions} kalorier, ${kolhydrater * noPortions} kolhydrater\nPortionsvikt motsvarar ${portionWeight * noPortions}g"
    }
}