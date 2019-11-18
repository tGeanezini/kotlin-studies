package com.tgeanezini.mobile.dinnerdecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Barbecue", "Burgers", "Pizza", "McDonalds", "Madero")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decide_button.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selected_food_label.text = foodList[randomFood]
        }

        add_food_button.setOnClickListener {
            val newFood = add_food_text.text.toString()
            foodList.add(newFood)
            add_food_text.text.clear()
        }
    }
}
