package com.estg.recursoteste.ui.notifications

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.estg.recursoteste.databinding.FragmentNotificationsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//import com.google.firebase.firestore.*


class NotificationsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore

        val data = hashMapOf(
            "Nome" to "Rui Alves",
            "Cargo" to "Treinador",
        )

        db.collection("Utilizador")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    ContentValues.TAG,
                    "DocumentSnapshot written with ID: ${documentReference.id}"
                )
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
    /*
    private lateinit var nome: EditText
    private lateinit var cargo: EditText
    private lateinit var data: EditText
    private lateinit var botaoGuardar: Button
    val db = Firebase.firestore
*/

    var name: TextView? = null
    /*
        private val db: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nome = findViewById(R.id.idNome)
        cargo = findViewById(R.id.idCargo)
        data = findViewById(R.id.idData)
        botaoGuardar = findViewById(R.id.guardarDados)

        botaoGuardar.setOnClickListener{

            val sPrimeiroNome = nome.text.toString().trim()
            val sCargo = cargo.text.toString().trim()
            val sData = data.text.toString().trim()

            val user = hashMapOf(
                "nome" to sPrimeiroNome,
                "cargo" to sCargo,
                "data" to sData
            )
            db.collection("utilizadores")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,"Sucesso", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this,"Erro ao criar", Toast.LENGTH_LONG).show()
                }


        }


    }
    */

    //Variáveis
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}