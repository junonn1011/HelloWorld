package com.example.myhelloworld

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //val --> constant
    // var --> still can change the value/put value later
    lateinit var diceImg : ImageView
    lateinit var numberText : TextView
    //var diceImg :ImageView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImage)
        numberText = findViewById(R.id.numberText)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        Toast.makeText( this,"Button Clicked",
        Toast.LENGTH_SHORT).show()

        val randomNumber = (1..6).random() //RANGE

        val numberText: TextView = findViewById(R.id.numberText)
        numberText.text = randomNumber.toString()
        val diceImg : ImageView=findViewById(R.id.diceImage)
        val imgSrc = when (randomNumber){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(imgSrc)
        Toast.makeText( this,randomNumber.toString(),
            Toast.LENGTH_SHORT).show()
    }
}