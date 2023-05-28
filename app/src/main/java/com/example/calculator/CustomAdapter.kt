package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CustomAdapter(private var operation:ArrayList<String>) : Adapter<CustomAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): ViewHolder(itemView){
        val tvSequence:TextView = itemView.findViewById(R.id.tvSequence)
        val tvOperation:TextView = itemView.findViewById(R.id.tvOperation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //connect the layout to be use
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_layout,
            parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int{
        return operation.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sequence = (position+1).toString()
        holder.tvSequence.text = sequence
        holder.tvOperation.text = operation[position]
    }
}