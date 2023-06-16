package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class SecondScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //buttons
        val roll10d6Button = findViewById<Button>(R.id.roll10d6Button)
        val switchScreenButton = findViewById<Button>(R.id.switchToDndButton)

        // 10 results
        val resultTextView1 = findViewById<TextView>(R.id.rolledTextView1)
        val resultTextView2 = findViewById<TextView>(R.id.rolledTextView2)
        val resultTextView3 = findViewById<TextView>(R.id.rolledTextView3)
        val resultTextView4 = findViewById<TextView>(R.id.rolledTextView4)
        val resultTextView5 = findViewById<TextView>(R.id.rolledTextView5)
        val resultTextView6 = findViewById<TextView>(R.id.rolledTextView6)
        val resultTextView7 = findViewById<TextView>(R.id.rolledTextView7)
        val resultTextView8 = findViewById<TextView>(R.id.rolledTextView8)
        val resultTextView9 = findViewById<TextView>(R.id.rolledTextView9)
        val resultTextView10 = findViewById<TextView>(R.id.rolledTextView10)

        switchScreenButton.setOnClickListener {
            //switch screens
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        roll10d6Button.setOnClickListener {
            //set each of the result text views to a different random number
            resultTextView1.text = (Random.nextInt(6) + 1).toString()
            resultTextView2.text = (Random.nextInt(6) + 1).toString()
            resultTextView3.text = (Random.nextInt(6) + 1).toString()
            resultTextView4.text = (Random.nextInt(6) + 1).toString()
            resultTextView5.text = (Random.nextInt(6) + 1).toString()
            resultTextView6.text = (Random.nextInt(6) + 1).toString()
            resultTextView7.text = (Random.nextInt(6) + 1).toString()
            resultTextView8.text = (Random.nextInt(6) + 1).toString()
            resultTextView9.text = (Random.nextInt(6) + 1).toString()
            resultTextView10.text = (Random.nextInt(6) + 1).toString()
        }
    }
}