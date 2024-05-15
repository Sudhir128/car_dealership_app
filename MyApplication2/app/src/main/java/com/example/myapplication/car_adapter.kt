package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CarsItemBinding

class CarAdapter(private val cars: List<Car>) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(private val binding: CarsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val carNameTextView: TextView = binding.carNameTextView
        val yearTextView: TextView = binding.yearTextView
        val kmsTextView: TextView = binding.kmsTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.carNameTextView.text = car.name
        holder.yearTextView.text = car.year
        holder.kmsTextView.text = car.kms.toString()
        // Bind more data if needed
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}
