package com.example.myhelloworld

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputDevice
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    //val --> constant
    // var --> still can change the value/put value later
    lateinit var diceImg : ImageView
    lateinit var numberText : TextView
    lateinit var editPlayerName :EditText
    lateinit var playerNameTV :TextView
    //var diceImg :ImageView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImage)
        numberText = findViewById(R.id.headerText)
        editPlayerName = findViewById(R.id.editPlayerNameET)
        playerNameTV = findViewById(R.id.playerName)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        Toast.makeText( this,"Button Clicked",
            Toast.LENGTH_SHORT).show()

        val randomNumber = (1..6).random() //RANGE

        val numberText: TextView = findViewById(R.id.headerText)
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

    private fun updatePlayerName(view: View){
        playerNameTV.text = editPlayerName.text

        editPlayerName.text.clear()
        editPlayerName.clearFocus()

        //hide keyboard after update player name
        //val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodService
        //imm.hideSoftInputFormWindow(view.windowToken,0)
    }
}