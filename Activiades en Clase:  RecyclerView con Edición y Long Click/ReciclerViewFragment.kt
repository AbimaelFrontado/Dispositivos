package com.example.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.adapter.UsuarioAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var userAdapter: UsuarioAdapter
    private lateinit var userRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initAdd()
    }

    private fun initAdd() {
        val btnAgregar = requireView().findViewById<FloatingActionButton>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
            val position = userAdapter.itemCount
            val nuevoUsuario = Usuario("Usuario $position", 20, "correo$position@gmail.com", "1234")
            userAdapter.addUser(nuevoUsuario)
            userRecyclerView.scrollToPosition(position)
        }
    }

    private fun initRecyclerView() {
        userAdapter = UsuarioAdapter(UsuarioProvider.instance.listaUsuario)
        userRecyclerView = requireView().findViewById(R.id.recyclerViewUsuarios)
        userRecyclerView.adapter = userAdapter
        userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
    }
}
