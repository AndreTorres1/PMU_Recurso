package com.estg.recursoteste.ui.dashboard

import com.estg.recursoteste.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estg.recursoteste.databinding.FragmentDashboardBinding
import com.estg.recursoteste.ui.Model
import com.estg.recursoteste.ui.MyAdapter
import com.estg.recursoteste.ui.adicionarTracker
import com.google.firebase.firestore.*


class DashboardFragment : Fragment() {
    //variáveis
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private var recyclerView: RecyclerView? = null
    private lateinit var db: FirebaseFirestore
    private lateinit var userArrayList: ArrayList<Model>
    private lateinit var myAdapter: MyAdapter

    //abre uma nova atividade

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val bind = FragmentDashboardBinding.inflate(layoutInflater)

        bind.paginaCriarTracker.setOnClickListener {
            val intent =
                Intent(this@DashboardFragment.requireContext(), adicionarTracker::class.java)
            startActivity(intent)

        }

        val view: View = bind.root
        var localRecyclerView = this.recyclerView
        localRecyclerView = bind.root.findViewById(R.id.recyclerView)
        localRecyclerView.layoutManager = LinearLayoutManager(view.context)
        localRecyclerView.setHasFixedSize(true)
        userArrayList = arrayListOf()
        myAdapter = MyAdapter(userArrayList)

        localRecyclerView.adapter = myAdapter


        EventChangeListener()

        return view


    }
    private fun EventChangeListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("Trackers").orderBy("barco", Query.Direction.ASCENDING).
        addSnapshotListener(object  : EventListener<QuerySnapshot> {
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

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_dashboard)
//
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//
//        userArrayList = arrayListOf()
//
//
//        myAdapter = MyAdapter(userArrayList)
//
//        recyclerView.adapter = myAdapter
//
//        EventChangeListener()
//
//    }

//    private fun EventChangeListener() {
//
//        db = FirebaseFirestore.getInstance()
//        db.collection("Trackers").orderBy("barco", Query.Direction.ASCENDING).
//        addSnapshotListener(object  : EventListener<QuerySnapshot> {
//            override fun onEvent(
//                value: QuerySnapshot?,
//                error: FirebaseFirestoreException?
//            ) {
//
//                if (error != null){
//                    Log.e("Firestore error", error.message.toString())
//                    return
//                }
//                for(dc : DocumentChange in value?.documentChanges!!){
//                    if(dc.type == DocumentChange.Type.ADDED){
//                        userArrayList.add(dc.document.toObject(Model::class.java))
//                    }
//                }
//                myAdapter.notifyDataSetChanged()
//            }
//
//        })
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

