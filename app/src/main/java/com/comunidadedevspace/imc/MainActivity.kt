package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes EditText
            //Criar uma variável e associar o componente de UI <EditText>
        // Colocar ação no botão setOnClickListener

        val peso = findViewById<TextInputEditText>(R.id.pesoEditText)
        val altura = findViewById<TextInputEditText>(R.id.alturaEditText)
        val calcular = findViewById<Button>(R.id.cal_button)

        calcular.setOnClickListener {
            val peso = peso.text
            val altura = altura.text
            println("meu primeiro aplicativo teste" + peso)
        }



    }
}