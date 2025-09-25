/**
 * Descripción del problema: Muestra la nota recibida y da opciones de compartir o editar.
 * Autor: Abimael Ernesto Frontado Fajardo
 * Fecha de creación: 25/09/2025
 * Fecha de última modificación: 25/09/2025
 */

package com.abi.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        // Recuperar la nota del Intent
        val nota = intent.getStringExtra("nota")

        // Inicializar las vistas
        val notaTextView: TextView = findViewById(R.id.notaTextView)
        val compartirButton: Button = findViewById(R.id.compartirButton)
        val editarButton: Button = findViewById(R.id.editarButton)

        // Mostrar la nota recibida
        notaTextView.text = nota

        // Configurar los listeners de los botones
        compartirButton.setOnClickListener {
            // Mostrar un Toast y regresar
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_OK)
            finish()
        }

        editarButton.setOnClickListener {
            // Devolver la nota a la actividad anterior para que pueda ser editada
            val returnIntent = Intent().apply {
                putExtra("nota_editada", nota)
            }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
        
    } 

}
