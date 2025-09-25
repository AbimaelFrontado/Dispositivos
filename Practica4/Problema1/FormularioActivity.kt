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
}
