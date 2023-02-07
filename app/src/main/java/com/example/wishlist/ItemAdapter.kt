package com.example.wishlist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val wishedItems: MutableList<WishedItem>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val priceTextView: TextView
        val linkTextView: TextView

        init{
            nameTextView = itemView.findViewById(R.id.listedName)
            priceTextView = itemView.findViewById(R.id.listedPrice)
            linkTextView = itemView.findViewById(R.id.listedURL)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.wishlisted_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wishedItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = wishedItems[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.linkTextView.text = item.link
    }

}