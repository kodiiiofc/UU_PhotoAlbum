package com.kodiiiofc.example.photoalbum

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinishActivity : AppCompatActivity() {

    private lateinit var finishBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)

        finishBTN = findViewById(R.id.btn_finish)

        finishBTN.setOnClickListener {
            finish()
        }

    }


}