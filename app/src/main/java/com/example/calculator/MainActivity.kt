package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private var text = ""
    private var value =  ""
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
        //clear the input
        btnAc.setOnClickListener{
            tvPreview.text = ""
            tvText.text = ""
        }
    }


    //reference the views needed
    private fun initialize() {
        tvText = findViewById(R.id.tvValue)
        tvPreview = findViewById(R.id.tvPreview)
        btnAc = findViewById(R.id.btnAc)

    }



    fun buttonClick(view:View){
        //when clicked the button it will appear on the preview of text
        text  += (view as Button).text.toString()
        tvText.text = text
    }

    fun operationButton(view: View) {
        /* when one of the operators has been clicked
        it indicates that new number will be added
        show to the preview the number before the mathematical operator
        */
        value += text + (view as Button).text.toString()
        tvPreview.text = value

        tvText.text = "0" //make it zero after the operator has been clicked
        text=""
    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View) {
        value += tvText.text
        tvPreview.text = "$value="
        text=""

        val expression = tvPreview.text.toString().trimEnd('=')
        val result = evaluateMathExpression(expression)
        tvText.text = result.toString()
    }

    //a function that turning String into Mathematical expression
    private fun evaluateMathExpression(expression: String): Double {
        val exp = ExpressionBuilder(expression).build()
        return exp.evaluate()
    }

}


