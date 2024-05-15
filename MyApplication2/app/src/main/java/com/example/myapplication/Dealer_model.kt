package com.example.myapplication

import com.google.firebase.firestore.PropertyName

class Dealer_model {
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("location") @set:PropertyName("location") var location: String = "",
    @get:PropertyName("contact") @set:PropertyName("contact") var contact: String = ""
}