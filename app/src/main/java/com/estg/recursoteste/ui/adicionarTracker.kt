package com.estg.recursoteste.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estg.recursoteste.R
import com.estg.recursoteste.databinding.ActivityAdicionarTrackerBinding
import com.estg.recursoteste.ui.dashboard.DashboardFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.Timestamp
import java.util.*


class adicionarTracker : AppCompatActivity() {
    lateinit var binding: ActivityAdicionarTrackerBinding
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_tracker)
        binding = ActivityAdicionarTrackerBinding.inflate(layoutInflater)




        //GUARDA TRACKERS
            val identificador = findViewById<EditText>(R.id.inputId)
            val barco = findViewById<EditText>(R.id.barco)
            val botaoGuardar = findViewById<Button>(R.id.btnAdicionarTracker)
            botaoGuardar.setOnClickListener {

                val sPrimeiroNome = identificador.text.toString().trim()
                val sCargo = barco.text.toString().trim()

                val user = hashMapOf(
                    "identificador" to sPrimeiroNome,
                    "barco" to sCargo,
                )
                db.collection("Trackers")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Erro ao criar", Toast.LENGTH_LONG).show()
                    }


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