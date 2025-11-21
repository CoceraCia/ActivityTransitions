package com.coceracia.transitions.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coceracia.transitions.R
import com.google.android.material.button.MaterialButton

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnExit = findViewById<MaterialButton>(R.id.mbExit)
        btnExit.setOnClickListener {
            finish()
        }

        val btnHelp = findViewById<MaterialButton>(R.id.mbHelp)
        btnHelp.setOnClickListener {
            AlertDialog.Builder(this).setTitle("HELP").setMessage("This is a simple app").setPositiveButton("OK", null).show()
        }

        val btnPlay = findViewById<MaterialButton>(R.id.mbPlay)
        btnPlay.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )

            startActivity(intent, options.toBundle())
        }
    }
}