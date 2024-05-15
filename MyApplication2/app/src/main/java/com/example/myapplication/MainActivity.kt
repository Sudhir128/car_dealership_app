package com.example.myapplication

import android.content.Intent
import android.media.Image
import com.google.firebase.FirebaseApp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage_ui)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        FirebaseApp.initializeApp(this)

        // Find the "New Car" image button
        val newCarButton = findViewById<ImageView>(R.id.addcarimage)

        // Set click listener for "New Car" button
        newCarButton.setOnClickListener {
            val intent = Intent(this, NewCarActivity::class.java)
            // Generate random car list
            val randomCars = getRandomCars()

            // Pass the car list as an ArrayList through Intent
            intent.putParcelableArrayListExtra("cars", ArrayList(randomCars))

            startActivity(intent)
            // Query Firebase for dealers data
            dealersCollection.get()
                .addOnSuccessListener { result ->
                    val dealersList = mutableListOf<Dealer>()
                    for (document in result) {
                        val dealer = document.toObject(Dealer::class.java)
                        dealersList.add(dealer)
                    }
                    val adapter = DealerAdapter(dealersList)
                    recyclerView.adapter = adapter
                }
                .addOnFailureListener { exception ->
                    // Handle errors
                }

    }

    fun goToServicePage(view: View) {
        val intent = Intent(this, ServiceActivity::class.java)
        startActivity(intent)
    }

    fun goToNewCar(view: View) {
        val intent = Intent(this, NewCarActivity::class.java)
        startActivity(intent)
    }

    // Function to navigate to BuyCarActivity
    fun goToBuyCar(view: View) {
        val intent = Intent(this, BuyCarActivity::class.java)
        startActivity(intent)
    }

    // Function to navigate to SellCarActivity
    fun goToSellCar(view: View) {
        val intent = Intent(this, SellCarActivity::class.java)
        startActivity(intent)
    }
}
