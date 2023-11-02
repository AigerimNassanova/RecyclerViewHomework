package com.example.recyclerviewhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = DrinkAdapter()
    private val imageIdList = listOf(
        R.drawable.coffee_cream,
        R.drawable.coffee_cocoa,
        R.drawable.frappuccino,
        R.drawable.frappucciono_cream,
        R.drawable.tea,
        R.drawable.water_tea
    )

    private val titleList = listOf(
        "Coffee Cream",
        "Coffee Cocoa",
        "Frappuccino",
        "Frappuccino Cream",
        "Tea",
        "Water Tea"
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager= GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                if (index > 5) index = 0
                val drink = Drink(imageIdList[index], titleList[index])
                adapter.addDrink(drink)
                index++
            }
        }
    }
}