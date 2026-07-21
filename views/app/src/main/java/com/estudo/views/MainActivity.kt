package com.estudo.views

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

        var countryList = resources.getStringArray(R.array.countries)
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val countryName: String = parent.getItemAtPosition(position).toString()
            Toast
                .makeText(
                    applicationContext,
                    "You selected the country ${countryName}",
                    Toast.LENGTH_LONG
                )
                .show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}