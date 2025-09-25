/**
 * Descripción del problema: Formulario de perfil que envía datos a una segunda pantalla.
 * Autor: Abimael Ernesto Frontado Fajardo
 * Fecha de creación: 25/09/2025
 * Fecha de última modificación: 25/09/2025
 *
 * NOTA: La clase 'AppCompatActivity' y las dependencias de AndroidX son necesarias para usar 'registerForActivityResult'.
 */

package com.abi.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable
 
class FormularioActivity : AppCompatActivity() {
 
    private lateinit var nombreEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var ciudadEditText: EditText
    private lateinit var correoEditText: EditText
    private lateinit var continuarButton: Button

    // Contrato para manejar el resultado de la siguiente actividad
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // El resultado de la segunda actividad indica que el perfil fue guardado
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Inicialización de las vistas
        nombreEditText = findViewById(R.id.nombreEditText)
        edadEditText = findViewById(R.id.edadEditText)
        ciudadEditText = findViewById(R.id.ciudadEditText)
        correoEditText = findViewById(R.id.correoEditText)
        continuarButton = findViewById(R.id.continuarButton)

        // Restaurar estado si la actividad fue recreada (ej. por rotación)
        if (savedInstanceState != null) {
            nombreEditText.setText(savedInstanceState.getString(NAME_KEY))
            edadEditText.setText(savedInstanceState.getString(AGE_KEY))
            ciudadEditText.setText(savedInstanceState.getString(CITY_KEY))
            correoEditText.setText(savedInstanceState.getString(EMAIL_KEY))
        }

        continuarButton.setOnClickListener {
            // Recoger los datos del formulario
            val nombre = nombreEditText.text.toString()
            val edad = edadEditText.text.toString()
            val ciudad = ciudadEditText.text.toString()
            val correo = correoEditText.text.toString()

            // Crear el objeto Usuario con los datos
            val usuario = Usuario(nombre, edad, ciudad, correo)

            // Crear un Intent para iniciar ResumenActivity
            val intent = Intent(this, ResumenActivity::class.java).apply {
                // Pasar el objeto Usuario a la siguiente actividad
                putExtra("usuario", usuario as Serializable)
            }
            // Lanzar la segunda actividad y esperar un resultado
            startForResult.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar el texto de cada EditText en el Bundle
        outState.putString(NAME_KEY, nombreEditText.text.toString())
        outState.putString(AGE_KEY, edadEditText.text.toString())
        outState.putString(CITY_KEY, ciudadEditText.text.toString())
        outState.putString(EMAIL_KEY, correoEditText.text.toString())
    }
    
}
