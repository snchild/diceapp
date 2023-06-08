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
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        d4Button.setOnClickListener {
            //specify what happens when we click the button
            //right now: get random number, display as the result
            val rand = Random.nextInt(4) + 1
            resultTextView.text = rand.toString()
        }

        /*setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
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