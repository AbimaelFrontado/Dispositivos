/**
 * Descripción del problema: Editor de notas que envía texto a una segunda pantalla.
 * Autor: Abimael Ernesto Frontado Fajardo
 * Fecha de creación: 25/09/2025
 * Fecha de última modificación: 25/09/2025
 */

package com.abi.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
 
// Clave para guardar el estado de la nota
private const val NOTE_KEY = "note_key"

class EditorActivity : AppCompatActivity() {

    private lateinit var notaEditText: EditText
    private lateinit var compartirButton: Button

    // Contrato para manejar el resultado de la siguiente actividad
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Si la nota fue compartida o editada, el resultado viene en el intent
            val notaEditada = result.data?.getStringExtra("nota_editada")
            notaEditText.setText(notaEditada)
        }
        
    }
    
}
