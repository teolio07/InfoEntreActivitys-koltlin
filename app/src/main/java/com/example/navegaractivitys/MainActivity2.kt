package com.example.navegaractivitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val campoMensaje = findViewById<TextView>(R.id.txtMensaje)

        //recupeamos la info que viene del intent
        var miBundle:Bundle? = this.intent.extras

        //se asigna la informacion al text view
        if(miBundle != null){
            if(miBundle.getDouble("promedio") >= 3.5){
                campoMensaje.setTextColor(Color.GREEN)
                campoMensaje.text = "Hla ${miBundle.getString("Nombre") } bienvenido \n Sus notas son:\n ${miBundle.getDouble("nota1") } \n ${miBundle.getDouble("nota2") } \n ${miBundle.getDouble("nota3") } \n Su promedio es: ${miBundle.getDouble("promedio")} \n ${miBundle.getString("Mensaje")}"
            }else if (miBundle.getDouble("promedio") < 3.5){
                campoMensaje.setTextColor(Color.RED)
                campoMensaje.text = "Hla ${miBundle.getString("Nombre") } bienvenido \n Sus notas son:\n ${miBundle.getDouble("nota1") } \n ${miBundle.getDouble("nota2") } \n ${miBundle.getDouble("nota3") } \n Su promedio es: ${miBundle.getDouble("promedio")} \n ${miBundle.getString("Mensaje")}"

            }else{

            }

        }

        var btnSalir = findViewById<Button>(R.id.btnsalir)
        btnSalir.setOnClickListener({onClick()})


    }

    private fun onClick(){
        finish()
    }
}