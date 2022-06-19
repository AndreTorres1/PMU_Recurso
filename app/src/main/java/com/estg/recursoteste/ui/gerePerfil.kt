package com.estg.recursoteste.ui

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estg.recursoteste.R
import com.estg.recursoteste.databinding.ActivityAdicionarTrackerBinding
import com.estg.recursoteste.databinding.FragmentNotificationsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class gerePerfil : AppCompatActivity() {
    val db = Firebase.firestore
    lateinit var binding: FragmentNotificationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_notifications)
        binding = FragmentNotificationsBinding.inflate(layoutInflater)


        //GUARDA TRACKERS
        val idNome = findViewById<EditText>(R.id.idNome)
        val idCargo = findViewById<EditText>(R.id.idCargo)

        val botaoGuarda = findViewById<Button>(R.id.btnGuardar)
        botaoGuarda.setOnClickListener {

            val sPrimeiroNome = idNome.text.toString().trim()
            val sCargo = idCargo.text.toString().trim()

            val user = hashMapOf(
                "nome" to sPrimeiroNome,
                "cargo" to sCargo,
            )
            db.collection("teste")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao criar", Toast.LENGTH_LONG).show()
                }


        }
    }
}