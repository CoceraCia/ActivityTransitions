package com.coceracia.transitions.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coceracia.transitions.R
import com.google.android.material.button.MaterialButton

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tempTextView = findViewById<TextView>(R.id.tvFinalResult)
        tempTextView.text = intent.getStringExtra("VALUE")

        val mbMenu = findViewById<MaterialButton>(R.id.mbResultMenu)
        mbMenu.setOnClickListener {
            finish()
            overridePendingTransition(R.drawable.slide_in_right, R.drawable.slide_out_left)
        }
    }
}