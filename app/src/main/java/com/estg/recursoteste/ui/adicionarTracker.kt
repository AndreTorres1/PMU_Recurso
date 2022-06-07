package com.estg.recursoteste.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estg.recursoteste.R
import com.estg.recursoteste.databinding.ActivityAdicionarTrackerBinding
import com.estg.recursoteste.ui.dashboard.DashboardFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class adicionarTracker : AppCompatActivity() {
    lateinit var binding: ActivityAdicionarTrackerBinding
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_tracker)
        binding = ActivityAdicionarTrackerBinding.inflate(layoutInflater)

        val data = hashMapOf(
            "identificador" to "2",
            "barco" to "Q-14",
        )

        db.collection("Trackers")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }


        // ACOES BOTOES
        val btninfoAvancada = findViewById<Button>(R.id.btnInformacoesAvancadas)
        btninfoAvancada.setOnClickListener {
            val Intent = Intent(this, informacoesAvancadas::class.java)
            startActivity(Intent)

        }
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val Intent1 = Intent(this, DashboardFragment::class.java)
            startActivity(Intent1)
        }


    }

}