package com.example.mccanalytic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        var imagew = intent.getIntExtra("image",0)
        var namew = intent.getStringExtra("name")
        var pricew = intent.getStringExtra("price")

        prodect_image.setImageResource(imagew)
        t_name.setText(namew).toString()
        price.setText(pricew).toString()

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "main screen")
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)

    }
}