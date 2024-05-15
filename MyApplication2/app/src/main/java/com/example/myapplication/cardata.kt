package com.example.myapplication

import java.util.Date

data class CarData(
    val brand: String = "",
    val model: String = "",
    val fuelType: String = "",
    val yearofreg: Date,
    val insure_valid: Date,
    val price: Number,
    val kms: Number,
    val username: String = "",
    val pno: String = ""
    // Add more properties as needed
)