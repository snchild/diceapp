package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.ui.theme.QuizAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize each thing that does stuff
        val d4Button = findViewById<Button>(R.id.d4Button)
        val d6Button = findViewById<Button>(R.id.d6Button)
        val d8Button = findViewById<Button>(R.id.d8Button)
        val d10Button = findViewById<Button>(R.id.d10Button)
        val d12Button = findViewById<Button>(R.id.d12Button)
        val d20Button = findViewById<Button>(R.id.d20Button)
        val rollButton = findViewById<Button>(R.id.rollButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val diceTextView = findViewById<TextView>(R.id.diceTextView)

        //create dictionary that has value of the number of each of the dice
        val numDiceMap = mutableMapOf<Int, Int>()
        numDiceMap[4] = 0
        numDiceMap[6] = 0
        numDiceMap[8] = 0
        numDiceMap[10] = 0
        numDiceMap[12] = 0
        numDiceMap[20] = 0

        d4Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[4] = (numDiceMap[4] ?:0 ) + 1 //the ?: 0 says to use 0 if numDiceMap[4] is null

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        d6Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[6] = (numDiceMap[6] ?:0 ) + 1

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        d8Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[8] = (numDiceMap[8] ?:0 ) + 1

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        d10Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[10] = (numDiceMap[10] ?:0 ) + 1

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        d12Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[12] = (numDiceMap[12] ?:0 ) + 1

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        d20Button.setOnClickListener {
            //increase the number of that type of dice that'll be rolled
            numDiceMap[20] = (numDiceMap[20] ?:0 ) + 1

            //display the total number of dice rolled
            diceTextView.text = mapToString(numDiceMap)
        }
        rollButton.setOnClickListener {
            val result = rollDice(numDiceMap)
            resultTextView.text = result.toString()
        }
        clearButton.setOnClickListener {
            //clear the numDiceMap
            numDiceMap[4] = 0
            numDiceMap[6] = 0
            numDiceMap[8] = 0
            numDiceMap[10] = 0
            numDiceMap[12] = 0
            numDiceMap[20] = 0

            //clear resultTextView
            resultTextView.text = ""
            //clear diceTextView
            diceTextView.text = "0d0"
        }

    }
    private fun mapToString(diceMap: Map<Int, Int>): String{
        val diceTypes = listOf(4,6,8,10,12,20)
        var totalString = ""
        for (type in diceTypes){
            if ((diceMap[type] != 0) and (totalString == "")){
                totalString += diceMap[type].toString() + "d" + type.toString()
            }else if (diceMap[type] != 0){
                totalString += " + " + diceMap[type].toString() + "d" + type.toString()
            }
        }
        return totalString
    }
    private fun rollDice(diceMap: Map<Int, Int>): Int{
        val diceTypes = listOf(4,6,8,10,12,20)
        var totalRoll = 0

        for (type in diceTypes){
            //for the number of diceMap[type] <- needs to not go through if number = 0
            for (i in 0 until (diceMap[type] ?: 0))
            {
                val rand = Random.nextInt(type) + 1
                totalRoll += rand
            }
        }
        return totalRoll
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizAppTheme {
        Greeting("Android")
    }
}