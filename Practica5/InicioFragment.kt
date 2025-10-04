/**
 * Descripción corta del problema:
 * Fragmento inicial que muestra el botón "Nuevo pedido" y permite iniciar el flujo del configurador de comida.
 *
 * Autor: Abimael Frontado
 * Fecha creación: 04/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.abi.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.navigation.fragment.findNavController
import com.abi.myapplication.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)

        binding.btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
