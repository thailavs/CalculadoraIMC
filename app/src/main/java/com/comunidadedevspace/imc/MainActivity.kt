package com.comunidadedevspace.imc

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.comunidadedevspace.imc.ResultActivity
import com.google.android.material.snackbar.Snackbar
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
            val pesoString: String = peso.text.toString()
            val alturaString: String = altura.text.toString()

            if (pesoString == "" || alturaString == "") {
                //da pra colocar assim ou também colocar if (pesoString.isEmpty()
                // mostrar mensagem para o usuário
                Snackbar
                    .make(
                        findViewById(android.R.id.content),
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                try {
                    val pesoFloat = pesoString.toFloat()
                    val alturaFloat = alturaString.toFloat()

                    val alturaQ2 = alturaFloat * alturaFloat
                    val resultado = pesoFloat / alturaQ2


                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(KEY_RESULT_IMC, resultado)
                    startActivity(intent)
                    
                } catch (e: NumberFormatException) {
                    Snackbar
                        .make(
                            findViewById(android.R.id.content),
                            "Insira valores válidos",
                            Snackbar.LENGTH_LONG
                        )
                        .show()
                }
            }
        }
    }
}

