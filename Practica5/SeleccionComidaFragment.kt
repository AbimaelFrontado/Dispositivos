/**
 * Descripción corta del problema:
 * Fragmento que permite al usuario seleccionar el tipo de comida (pizza, hamburguesa o ensalada).
 * Al avanzar, envía la selección a SeleccionExtrasFragment mediante un Bundle.
 *
 * Autor: Abimael Frontado
 * Fecha creación: 04/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.abi.myapplication

import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.abi.myapplication.databinding.FragmentSeleccionComidaBinding

class SeleccionComidaFragment : Fragment() {
    private var _binding: FragmentSeleccionComidaBinding? = null
    private val binding get() = _binding!!
    private var comidaSeleccionada: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeleccionComidaBinding.inflate(inflater, container, false)

        // Recuperar datos si se edita el pedido
        setFragmentResultListener("editarPedido") { _, bundle ->
            comidaSeleccionada = bundle.getString("comida")
            when (comidaSeleccionada) {
                "Pizza" -> binding.radioPizza.isChecked = true
                "Hamburguesa" -> binding.radioHamburguesa.isChecked = true
                "Ensalada" -> binding.radioEnsalada.isChecked = true
            }
        }

        binding.btnSiguienteComida.setOnClickListener {
            val selectedId = binding.radioGroupComida.checkedRadioButtonId
            if (selectedId != -1) {
                val radioButton = binding.root.findViewById<RadioButton>(selectedId)
                comidaSeleccionada = radioButton.text.toString()

                val bundle = Bundle().apply {
                    putString("comida", comidaSeleccionada)
                }

                findNavController().navigate(R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment, bundle)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
