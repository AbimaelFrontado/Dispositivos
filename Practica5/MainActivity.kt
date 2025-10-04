/**
 * Descripción corta del problema:
 * Actividad principal que actúa como contenedor de los fragmentos del configurador de pedido
 * mediante un NavHostFragment definido en el archivo de navegación.
 *
 * Autor: Abimael Frontado
 * Fecha creación: 04/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.abi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abi.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
