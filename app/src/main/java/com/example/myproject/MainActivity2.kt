package com.example.myproject

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    lateinit var button: Button
    lateinit var textView: TextView
    var value = 0f
    lateinit var displayMetrics: DisplayMetrics
    var activity: Activity? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button = findViewById(R.id.btnShowDensity)
        textView = findViewById(R.id.textView)
        activity = this
        button.setOnClickListener {
            displayMetrics = DisplayMetrics()
            activity!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
            value = resources.displayMetrics.density
            textView.text = "Screen Density = $value"
        }
    }
}