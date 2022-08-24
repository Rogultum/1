package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {

            rollDice()
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show() --->.show() üst satırın en sonuna da koyulabilir

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"
        }

        //do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val dice2 = Dice(4)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when(diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            else -> R.drawable.dice_4

        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()


        val diceImage: ImageView = findViewById(R.id.imageView)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)

        }

        diceImage.contentDescription = diceRoll.toString()
        /**
         *
        val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
         */

        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = diceRoll.toString()

    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}