package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listedItems = findViewById<RecyclerView>(R.id.listedItems)
        var wishedItems: MutableList<WishedItem> = mutableListOf()
        val adapter = ItemAdapter(wishedItems)
        listedItems.adapter = adapter
        listedItems.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.submit).setOnClickListener{
            val name = findViewById<EditText>(R.id.itemName).text.toString()
            val price = findViewById<EditText>(R.id.itemPrice).text.toString()
            val link = findViewById<EditText>(R.id.itemURL).text.toString()

            findViewById<EditText>(R.id.itemName).text.clear()
            findViewById<EditText>(R.id.itemPrice).text.clear()
            findViewById<EditText>(R.id.itemURL).text.clear()

            val newItem = WishedItem(name, price, link)
            wishedItems.add(newItem)
            adapter.notifyItemInserted(wishedItems.size)
        }

    }
}