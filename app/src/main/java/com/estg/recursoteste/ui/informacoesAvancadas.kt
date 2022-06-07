package com.estg.recursoteste.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.estg.recursoteste.R
import com.estg.recursoteste.ui.dashboard.DashboardFragment

class informacoesAvancadas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacoes_avancadas)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val Intent1 = Intent(this, DashboardFragment::class.java)
            startActivity(Intent1)
        }
    }
}