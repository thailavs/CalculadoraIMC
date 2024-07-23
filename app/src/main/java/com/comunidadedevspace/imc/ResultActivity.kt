package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            WindowInsetsCompat.CONSUMED
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String = when {
            result <= 18.5f -> "MAGREZA"
            result > 18.5f && result <= 24.9f -> "NORMAL"
            result > 24.9f && result <= 29.9f -> "SOBREPESO"
            result > 30f && result <= 39.9f -> "OBESIDADE GRAVE"
            else -> "IMC INDEFINIDO"
        }
        tvClassificacao.text = classificacao
    }
}
