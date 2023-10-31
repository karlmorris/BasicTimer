package edu.temple.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var countdownTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdownTextView = findViewById<TextView>(R.id.countdownTextView)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            Thread {
                repeat(100) {
                    val timer = (100-it).toString()
                    Thread.sleep(1000)
                    Log.d("Countdown", timer)
                    //countdownTextView.text = timer
                }
            }.start()
        }



    }
}