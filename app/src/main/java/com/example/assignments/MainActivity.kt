package com.example.assignments

import ItemAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val itemList = listOf(
            Item(1, "https://example.com/image1.jpg", "Item 1"),
            Item(2, "https://example.com/image2.jpg", "Item 2")
        )


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList, ::onItemClicked, ::onLikeClicked)


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun onItemClicked(itemId: Int) {

        Toast.makeText(this, "Item $itemId clicked", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "Item $itemId clicked")
    }

    private fun onLikeClicked(itemId: Int) {

        Toast.makeText(this, "Like on Item $itemId", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "Like on Item $itemId")
    }

    private fun onShareClicked(itemId: Int) {

        Toast.makeText(this, "Share on Item $itemId", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "Share on Item $itemId")
    }
}
