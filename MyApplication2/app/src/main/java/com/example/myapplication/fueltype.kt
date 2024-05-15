package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class fuetype : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sell_car)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.editFuel)

        // Get the array of fuel types from resources
        val fuelTypes = resources.getStringArray(R.array.fuel_types)

        // Create an ArrayAdapter using the fuelTypes array and set it to the AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, fuelTypes)
        autoCompleteTextView.setAdapter(adapter)

        // Set item click listener to update the AutoCompleteTextView text when an item is selected
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedFuelType = adapter.getItem(position)
            autoCompleteTextView.setText(selectedFuelType, false) // false to prevent triggering text changed listener
        }
    }
}
