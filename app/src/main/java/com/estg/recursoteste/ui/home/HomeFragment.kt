package com.estg.recursoteste.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.estg.recursoteste.databinding.FragmentHomeBinding
import com.estg.recursoteste.ui.HomeMenu.historico

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bind = FragmentHomeBinding.inflate(layoutInflater)

        bind.btnHistorico.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(), historico::class.java)
            startActivity(intent)

        }

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}