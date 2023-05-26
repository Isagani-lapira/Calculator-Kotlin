package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var text: String? = ""
    private var value: String? = ""
    private lateinit var tvText: TextView
    private lateinit var tvPreview: TextView
    private lateinit var btnAc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        listener()
    }

    private fun listener() {
        btnAc.setOnClickListener{
            tvPreview.text = ""
            tvText.text = ""
        }
    }


    private fun initialize() {
        tvText = findViewById(R.id.tvValue)
        tvPreview = findViewById(R.id.tvPreview)
        btnAc = findViewById(R.id.btnAc)

    }



    fun buttonClick(view:View){
        text  += (view as Button).text.toString()
        tvText.text = text
    }

    fun operationButton(view: View) {
        value += text + (view as Button).text.toString()
        tvPreview.text = value
        text=""
    }

}


