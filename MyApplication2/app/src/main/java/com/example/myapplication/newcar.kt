package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class NewCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newcar)

        val recyclerView: RecyclerView = findViewById(R.id.)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = New
        recyclerView.adapter = adapter

        fetchDataFromFirestore(adapter)
    }

    private fun fetchDataFromFirestore(adapter: NewCarAdapter) {
        val firestore = FirebaseFirestore.getInstance()
        val collectionRef = firestore.collection("cars")

        collectionRef.get()
            .addOnSuccessListener { querySnapshot ->
                val carList = mutableListOf<Car>()

                for (document in querySnapshot.documents) {
                    val car = document.toObject<Car>()
                    car?.let { carList.add(it) }
                }

                adapter.setData(carList)
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Error getting documents: ", exception)

            }
    }

}