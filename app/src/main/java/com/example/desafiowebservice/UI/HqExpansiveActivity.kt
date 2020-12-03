package com.example.desafiowebservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservice.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_img_expansive.*

class HqExpansiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_expansive)

        toolbarImage.setNavigationOnClickListener {
            finish()
        }

        val picasso = Picasso.get()

        val img = intent.getStringExtra("img")
        picasso.load(img).into(imgHqExpansiveTrue)
    }
}