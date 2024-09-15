package com.kodiiiofc.example.photoalbum

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var startBTN: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startBTN = findViewById(R.id.btn_start)

        startBTN.setOnClickListener {

            val intent = Intent(this, PhotoalbumActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}