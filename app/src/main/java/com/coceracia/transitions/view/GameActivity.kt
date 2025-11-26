package com.coceracia.transitions.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coceracia.transitions.R
import com.google.android.material.button.MaterialButton


class GameActivity : AppCompatActivity() {
    private var startTime = 0L
    private var running = false

    private var actTime = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val timeTextView = findViewById<TextView>(R.id.tvCrono)
        val handler = Handler(Looper.getMainLooper())
        val updateTime = object : Runnable {
            override fun run() {
                if (running){
                    val elapsed = SystemClock.elapsedRealtime() - startTime
                    actTime = formatTime(elapsed)
                    timeTextView.text = actTime
                    handler.postDelayed(this, 16)
                }
            }
        }

        val btnPlayStop = findViewById<MaterialButton>(R.id.mbPlayStop)
        btnPlayStop.setOnClickListener {
            if (btnPlayStop.text == "PLAY"){
                running = true
                startTime = SystemClock.elapsedRealtime()
                handler.post(updateTime)
                btnPlayStop.text = "STOP"
            } else {
                running = false
                handler.removeCallbacks(updateTime)
                val intent = Intent(this, ResultActivity::class.java)
                val options = ActivityOptions.makeCustomAnimation(
                    this,
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
                )
                intent.putExtra("VALUE", actTime)
                startActivity(intent, options.toBundle())
                finish()
            }
        }

    }

    private fun formatTime(time: Long): String {
        val msLength = time.toString().length
        var ms = ""
        if (msLength <= 2){
            ms = time.toString()
        } else {
            ms = time.toString().substring((msLength - 2), msLength)
        }
        var s = time / 1000
        var m: Long = 0
        if (s >= 60){
            m = s/60
            s = s - m * 60
        }

        var h:Long = 0
        if (m >= 60){
            h = m/60
            m = m - h * 60
        }


        val completeTime = mutableListOf<String>()

        if (h.toString().length == 1){
            completeTime.add("0$h")
        } else {
            completeTime.add(h.toString())
        }

        if (m.toString().length == 1){
            completeTime.add("0$m")
        } else {
            completeTime.add(m.toString())
        }

        if (s.toString().length == 1){
            completeTime.add("0$s")
        } else {
            completeTime.add(s.toString())
        }

        if (msLength == 1){
            completeTime.add("0"+ms)
        } else {
            completeTime.add(ms)
        }

        return completeTime.joinToString(":")
    }
}