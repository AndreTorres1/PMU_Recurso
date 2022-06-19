package com.estg.recursoteste.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estg.recursoteste.R
import com.estg.recursoteste.ui.Model
import com.estg.recursoteste.ui.MyAdapter
import com.google.firebase.firestore.*

class showTrackers : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Model>
    private lateinit var myAdapter: MyAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_trackers)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()


        myAdapter = MyAdapter(userArrayList)

        recyclerView.adapter = myAdapter

        EventChangeListener()

    }
   private fun EventChangeListener() {

       db = FirebaseFirestore.getInstance()
       db.collection("Trackers").orderBy("cargo",Query.Direction.ASCENDING).
        addSnapshotListener(object  : EventListener<QuerySnapshot>{
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {

                if (error != null){
                    Log.e("Firestore error", error.message.toString())
                return
                }
                for(dc : DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        userArrayList.add(dc.document.toObject(Model::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }

        })
   }
}