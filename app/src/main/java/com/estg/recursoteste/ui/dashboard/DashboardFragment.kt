package com.estg.recursoteste.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.estg.recursoteste.databinding.FragmentDashboardBinding
import com.estg.recursoteste.ui.adicionarTracker


class DashboardFragment : Fragment() {
//variáveis
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    //abre uma nova atividade

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val bind = FragmentDashboardBinding.inflate(layoutInflater)

        bind.paginaCriarTracker.setOnClickListener{
            val intent = Intent(this@DashboardFragment.requireContext(),adicionarTracker::class.java)
            startActivity(intent)

        }
        return bind.root



        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: Button = binding.paginaCriarTracker

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

