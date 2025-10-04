/**
 * Descripción: Permite al usuario seleccionar los extras del pedido.
 * Autor: Abimael Frontado
 * Fecha creación: 04/10/2025
 * Última modificación: 04/10/2025
 */

package com.abi.myapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abi.myapplication.databinding.FragmentSeleccionExtrasBinding

class SeleccionExtrasFragment : Fragment() {
    private var _binding: FragmentSeleccionExtrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeleccionExtrasBinding.inflate(inflater, container, false)

        val comida = arguments?.getString("comida")

        binding.btnSiguienteExtras.setOnClickListener {
            val extras = mutableListOf<String>()
            if (binding.chkBebida.isChecked) extras.add("Bebida")
            if (binding.chkPapas.isChecked) extras.add("Papas")
            if (binding.chkPostre.isChecked) extras.add("Postre")

            val bundle = Bundle()
            bundle.putString("comida", comida)
            bundle.putStringArrayList("extras", ArrayList(extras))

            findNavController().navigate(R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment, bundle)
        }

        return binding.root
    }
}
