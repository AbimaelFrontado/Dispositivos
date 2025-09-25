/**
 * Descripción del problema: Muestra un resumen del perfil y permite confirmar o volver a editar.
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
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() { 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Recuperar el objeto Usuario del Intent
        val usuario = intent.getSerializableExtra("usuario") as? Usuario

        // Inicializar las vistas
        val nombreTextView: TextView = findViewById(R.id.nombreTextView)
        val edadTextView: TextView = findViewById(R.id.edadTextView)
        val ciudadTextView: TextView = findViewById(R.id.ciudadTextView)
        val correoTextView: TextView = findViewById(R.id.correoTextView)
        val confirmarButton: Button = findViewById(R.id.confirmarButton)
        val volverButton: Button = findViewById(R.id.volverButton)

        // Mostrar los datos del usuario si el objeto no es nulo
        usuario?.let {
            nombreTextView.text = "Nombre: ${it.nombre}"
            edadTextView.text = "Edad: ${it.edad}"
            ciudadTextView.text = "Ciudad: ${it.ciudad}"
            correoTextView.text = "Correo: ${it.correo}"
        }

        // Configurar los listeners de los botones
        confirmarButton.setOnClickListener {
            // Regresar a la actividad anterior con un resultado de OK
            setResult(Activity.RESULT_OK)
            finish()
        }

        volverButton.setOnClickListener {
            // Regresar a la actividad anterior sin un resultado específico
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        
    }  
    
}
