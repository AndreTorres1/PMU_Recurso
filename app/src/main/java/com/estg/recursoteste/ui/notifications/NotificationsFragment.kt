package com.estg.recursoteste.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.estg.recursoteste.R
import com.estg.recursoteste.databinding.FragmentNotificationsBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//import com.google.firebase.firestore.*


class NotificationsFragment : Fragment() {

    /*
    private lateinit var nome: EditText
    private lateinit var cargo: EditText
    private lateinit var data: EditText
    private lateinit var botaoGuardar: Button
    val db = Firebase.firestore
*/

    var name: TextView? = null

    val db = Firebase.firestore

    //Variáveis
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
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