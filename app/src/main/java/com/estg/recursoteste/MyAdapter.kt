package com.estg.recursoteste

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.estg.recursoteste.ui.Data
import com.google.firebase.firestore.auth.User

class MyAdapter(private val userList: ArrayList<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val data: Data = userList[position]
        holder.tracker.text = data.tracker
        holder.ocorrencia.text = data.ocorrencia

    }


    override fun getItemCount(): Int {
       return userList.size

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val tracker: TextView = itemView.findViewById(R.id.tracker)
        val ocorrencia: TextView = itemView.findViewById(R.id.ocorrencia)


    }
}
