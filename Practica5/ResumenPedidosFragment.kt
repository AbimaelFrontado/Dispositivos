/**
 * Descripción: Muestra el resumen del pedido, permite confirmar o editar.
 * Autor: Abimael Frontado
 * Fecha creación: 04/10/2025
 * Última modificación: 04/10/2025
 */

package com.abi.myapplication

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.abi.myapplication.databinding.FragmentResumenPedidoBinding

class ResumenPedidoFragment : Fragment() {
    private var _binding: FragmentResumenPedidoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResumenPedidoBinding.inflate(inflater, container, false)

        val comida = arguments?.getString("comida")
        val extras = arguments?.getStringArrayList("extras")

        binding.txtResumen.text = "Comida: $comida\nExtras: ${extras?.joinToString(", ")}"

        binding.btnConfirmar.setOnClickListener {
            Toast.makeText(requireContext(), "Pedido confirmado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.inicioFragment)
        }

        binding.btnEditar.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("comida", comida)
            setFragmentResult("editarPedido", bundle)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }

        return binding.root
    }
}
