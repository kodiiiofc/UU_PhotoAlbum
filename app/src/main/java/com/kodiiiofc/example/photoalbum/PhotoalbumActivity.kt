package com.kodiiiofc.example.photoalbum

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay

class PhotoalbumActivity : AppCompatActivity() {

    private lateinit var moveOut: Animation
    private lateinit var moveIn: Animation

    private lateinit var imageOneIV: ImageView
    private lateinit var imageTwoIV: ImageView

    private lateinit var nextBTN: Button

    val imageList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photoalbum)

        var imageIndex = 0

        imageOneIV = findViewById(R.id.iv_image_one)
        imageTwoIV = findViewById(R.id.iv_image_two)

        imageOneIV.setImageResource(imageList[imageIndex])
        imageTwoIV.setImageResource(imageList[imageIndex+1])

        moveIn = AnimationUtils.loadAnimation(this, R.anim.move_in)
        moveOut = AnimationUtils.loadAnimation(this, R.anim.move_out)

        val animationListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                if (animation == moveIn) {
                    imageOneIV.setImageResource(imageList[imageIndex])
                    imageTwoIV.visibility = android.view.View.VISIBLE
                    imageTwoIV.setImageResource(imageList[imageIndex + 1])
                }
                return
            }

            override fun onAnimationEnd(animation: Animation?) {
                if (animation == moveOut) {

                    imageTwoIV.visibility = android.view.View.INVISIBLE
                    imageOneIV.setImageResource(imageList[imageIndex + 1])
                    imageIndex++
                }

                return
            }

            override fun onAnimationRepeat(animation: Animation?) {
                return
            }
        }

        moveOut.setAnimationListener(animationListener)
        moveIn.setAnimationListener(animationListener)

        nextBTN = findViewById(R.id.btn_next)

        nextBTN.setOnClickListener {
            if (imageIndex < 4) {
                imageOneIV.startAnimation(moveOut)
                imageTwoIV.startAnimation(moveIn)
            } else {
                val intent = Intent(this, FinishActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

    }

}