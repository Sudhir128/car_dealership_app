package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestoreException

class DealerAdapter(private val dealers: List<Dealer>) : RecyclerView.Adapter<DealerAdapter.DealerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dealer, parent, false)
        return DealerViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealerViewHolder, position: Int) {
        val dealer = dealers[position]
        holder.bind(dealer)
    }

    override fun getItemCount(): Int {
        return dealers.size
    }

    class DealerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        private val contactTextView: TextView = itemView.findViewById(R.id.contactTextView)

        fun bind(dealer: Dealer) {
            nameTextView.text = dealer.name
            locationTextView.text = dealer.location
            contactTextView.text = dealer.contact
        }
    }
}
