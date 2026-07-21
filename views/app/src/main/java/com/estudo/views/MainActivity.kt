package com.estudo.views

import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var recyclerView: RecyclerView
    var countryNameList = ArrayList<String>()
    var detailsList = ArrayList<String>()
    var imageList = ArrayList<Int>()
    lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        countryNameList.add("Brazil")
        countryNameList.add("Germany")
        countryNameList.add("Spain")
        countryNameList.add("Cape verde")
        detailsList.add("This is a Brazil flag")
        detailsList.add("This is a Germany flag")
        detailsList.add("This is a Spain flag")
        detailsList.add("This is a Cape verde flag")

        imageList.add(R.drawable.brazil)
        imageList.add(R.drawable.brazil)
        imageList.add(R.drawable.brazil)
        imageList.add(R.drawable.brazil)

        adapter = CountryAdapter(countryNameList, detailsList, imageList, this@MainActivity)
        recyclerView.adapter = adapter
//        listView = findViewById(R.id.listView)

//        var countryList = resources.getStringArray(R.array.countries)
//        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
//        listView.adapter = arrayAdapter
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val countryName: String = parent.getItemAtPosition(position).toString()
//            Toast
//                .makeText(
//                    applicationContext,
//                    "You selected the country ${countryName}",
//                    Toast.LENGTH_LONG
//                )
//                .show()
//        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}