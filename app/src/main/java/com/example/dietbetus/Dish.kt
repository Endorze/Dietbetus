package com.example.dietbetus

import android.graphics.drawable.Drawable

enum class Dish(
    // Namn på maträtten
    val dishName: String,
    // Kalorier per 100 gram
    val caloriesPer100g: Int,
    // Normal portions vikt i gram
    val portionSize: Int,
    //
    val carbohydratesPer100g: Int,

    val photo: Int
)
{

    SOUP_WITH_PANCAKES("Ärtsoppa med Pannkakor (Utan sylt)", 247, 300, 13, R.drawable.artsoppa),
    CREAMY_SPINACHSOUP("Krämig Spenatsoppa (1 dl grädde)", 153, 300, 6, R.drawable.spenatsoppa),
    PASTA_CARBONARA("Pasta Carbonara", 213, 350, 18, R.drawable.carbonara),
    PASTA_MEATSAUCE("Pasta med Köttfärssås", 240, 300, 16, R.drawable.pastakottfers),
    LASAGNA("Lasagne", 135, 400, 15, R.drawable.lasagne),
    FLASKIS("Fläskugnspannkaka", 233, 300, 21, R.drawable.flaskpannkaka),
    //FLASK_WITH_ONIONSAUCE(),
    APPLE("Äpple", 52, 100, 14, R.drawable.apple),
    BANANA("Banan", 88, 100, 23, R.drawable.banan),
    CLEMENTINE("Clementin", 47, 100, 12, R.drawable.clementin),
    PEAR("Päron", 57, 100, 15, R.drawable.pear),
    ORANGE("Appelsin", 47, 100, 12, R.drawable.appelsin);


    fun getCaloriesPerPortion() : Int {
        return caloriesPer100g * portionSize / 100
    }
    fun getCarbonhydratesPerPortion(): Int {
        return carbohydratesPer100g * portionSize / 100
    }

    override fun toString(): String {
        return dishName
    }
}