package com.example.parkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var meal = 0.0
    var tipAmount: Double = 0.0
    var tipChoice = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealPrice: EditText = findViewById(R.id.idPrice)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.idBtnCharge)
        val result: TextView = findViewById(R.id.idResult)

        charges.setOnClickListener(){
            tipChoice = group.selectedItem.toString().toInt()
            meal = mealPrice.text.toString().toDouble()
            if (tipChoice == 5){
                tipAmount = meal * .05
            } else if (tipChoice == 10){
                tipAmount = meal * .10
            } else if (tipChoice == 15){
                tipAmount = meal * .15
            } else if (tipChoice == 20){
                tipAmount = meal * .20
            } else if (tipChoice == 25){
                tipAmount = meal * .25
            }

            val currency = DecimalFormat("$###,###.00")
            val totalChargesFormat = currency.format(tipAmount)
            result.text = "A $tipChoice% tip for a $$meal meal is $totalChargesFormat"
        }
    }
}