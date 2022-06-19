package com.estg.recursoteste.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estg.recursoteste.R

class MyAdapter(private val userList: ArrayList<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,
    parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int){
        val model : Model = userList[position]
        holder.identificador.text = model.identificador
        holder.barco.text = model.barco
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val identificador : TextView = itemView.findViewById(R.id.identificador)
        val barco : TextView = itemView.findViewById(R.id.barco)

    }

}