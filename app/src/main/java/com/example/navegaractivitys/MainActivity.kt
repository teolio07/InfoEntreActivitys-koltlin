package com.example.navegaractivitys

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var nombre: EditText? = null;
    var materia: EditText? = null;
    var nota1: EditText? = null;
    var nota2: EditText? = null;
    var nota3: EditText? = null;


    var txtResultado: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.editTextTextPersonName)
        materia = findViewById(R.id.materia)
        nota1 = findViewById(R.id.nota1)
        nota2 = findViewById(R.id.nota2)
        nota3 = findViewById(R.id.nota3)


        txtResultado = findViewById(R.id.txtResultado)

        val botonIngresar: Button = findViewById(R.id.button)
        botonIngresar.setOnClickListener { mostrar(1) }

        val botonIngresar2: Button = findViewById(R.id.button2)
        botonIngresar2.setOnClickListener { mostrar(2) }
    }

    private fun mostrar(but: Int) {


        when (but) {
            1 -> {
                var nombre: String = nombre!!.text.toString()
                var materia: String = materia!!.text.toString()
                var nota1: Double = nota1!!.text.toString().toDouble()
                var nota2: Double = nota2!!.text.toString().toDouble()
                var nota3: Double = nota3!!.text.toString().toDouble()
                var promedio: Double = (nota1 + nota2 + nota3) / 3
                var mensaje: String = ""
                if (promedio >= 3.5) {
                    txtResultado?.setTextColor(Color.GREEN)
                    mensaje = "Pasaste la materia"
                } else if (promedio < 3.5) {
                    txtResultado?.setTextColor(Color.RED)
                    mensaje = "No pasaste la materia"
                }
                txtResultado!!.text = "Bienvenido $nombre\n $materia\n $nota1\n $nota2\n $nota3\n Su promedio es: ${promedio}\n ${mensaje}"

                //Toast.makeText(this, "$nombre\n", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                //creamos el intent encargado comunicacion entre activitys
                val intent = Intent(this, MainActivity2::class.java)
                //creamos el bundle para el paso de informcaion entre activitys
                val mibundle: Bundle = Bundle()
                var nombre: String = nombre!!.text.toString()
                var materia: String = materia!!.text.toString()
                var nota1: Double = nota1!!.text.toString().toDouble()
                var nota2: Double = nota2!!.text.toString().toDouble()
                var nota3: Double = nota3!!.text.toString().toDouble()
                var promedio: Double =  (nota1 + nota2 + nota3) / 3
                var mensaje: String = ""
                if (promedio >= 3.5) {
                    mensaje = "Pasaste la materia"
                } else if (promedio < 3.5) {
                    mensaje = "No pasaste la materia"
                }
                mibundle.putString("Nombre", nombre)
                mibundle.putString("Materia", materia)
                mibundle.putDouble("nota1", nota1)
                mibundle.putDouble("nota2", nota2)
                mibundle.putDouble("nota3", nota3)
                mibundle.putDouble("promedio", promedio)
                mibundle.putString("Mensaje", mensaje)


                //le agragamos la informacion al intent para que sea emviada
                intent.putExtras(mibundle)
                //iniamos el llamdo a la nueva activity
                startActivity(intent)

            }
        }
    }
}