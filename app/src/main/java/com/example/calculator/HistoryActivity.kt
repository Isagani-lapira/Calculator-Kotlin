package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var rvHistory : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        initialize()
    }

    private fun initialize(){

        //arraylist
        val intent = intent
        val operationList = intent.getStringArrayListExtra("operation") as ArrayList<String>

        //set up the recyler view
        rvHistory = findViewById(R.id.rvHistory)
        rvHistory.layoutManager = LinearLayoutManager(this)
        rvHistory.adapter = CustomAdapter(operationList)
    }
}