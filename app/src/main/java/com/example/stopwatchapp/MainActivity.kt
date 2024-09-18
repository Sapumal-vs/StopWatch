package com.example.stopwatchapp

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private var running: Boolean = false
    private var offset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
        val startButton: Button = findViewById(R.id.start_button)
        val stopButton: Button = findViewById(R.id.stop_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        startButton.setOnClickListener {
            if (!running) {
                chronometer.base = SystemClock.elapsedRealtime() - offset
                chronometer.start()
                running = true
            }
        }

        stopButton.setOnClickListener {
            if (running) {
                chronometer.stop()
                offset = SystemClock.elapsedRealtime() - chronometer.base
                running = false
            }
        }

        resetButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            offset = 0
        }
    }
}
