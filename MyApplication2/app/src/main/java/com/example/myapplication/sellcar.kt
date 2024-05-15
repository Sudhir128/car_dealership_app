package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class sellcar : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sell_car)
        database = FirebaseDatabase.getInstance().reference

        val editTextBrand = findViewById<EditText>(R.id.editBrand)
        val editTextModel = findViewById<EditText>(R.id.editModel)
        val autoCompleteTextViewFuelType = findViewById<AutoCompleteTextView>(R.id.editFuel)

        val buttonPostAd = findViewById<Button>(R.id.postbutton)


        buttonPostAd.setOnClickListener {
            // Get user-entered data
            val brand = editTextBrand.text.toString()
            val model = editTextModel.text.toString()
            val fuelType = autoCompleteTextViewFuelType.text.toString()
            // Get other data as needed

            val carData = CarData(brand, model, fuelType)

            database.child("cars").push().setValue(carData)
        }
    }
}
