package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var context: Context = this


    private var text: String? = ""
    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    private fun initialize() {
        tvText = findViewById(R.id.tvValue)
    }

    fun buttonClick(view:View){
        text  += (view as Button).text.toString()
        tvText.text = text
    }

}