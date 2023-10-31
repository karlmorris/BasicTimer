package edu.temple.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var countdownTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdownTextView = findViewById<TextView>(R.id.countdownTextView)

        var coroutineScope: CoroutineScope? = null

        findViewById<Button>(R.id.startButton).setOnClickListener {

            // Cancel old job if any
            coroutineScope?.cancel()

            // Create new scope
            coroutineScope = CoroutineScope(Dispatchers.Default)

            coroutineScope?.launch {
                repeat(100) {
                    val timer = (100-it).toString()
                    delay(1000)
                    Log.d("Countdown", timer)
                    withContext(Dispatchers.Main) {
                        countdownTextView.text = timer
                    }
                }
            }
        }



    }
}