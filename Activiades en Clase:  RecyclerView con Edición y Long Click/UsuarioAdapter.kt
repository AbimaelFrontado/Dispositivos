package com.example.recyclerviewapp.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioAdapter(private val listaUsuarios: MutableList<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    inner class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        private val tvEdad: TextView = view.findViewById(R.id.tvEdad)
        private val tvCorreo: TextView = view.findViewById(R.id.tvCorreo)

        fun bind(usuario: Usuario) {
            tvNombre.text = usuario.nombre
            tvEdad.text = "Edad: ${usuario.edad}"
            tvCorreo.text = usuario.email

            // Long click para opciones
            itemView.setOnLongClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    AlertDialog.Builder(itemView.context)
                        .setTitle("Acción")
                        .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                            when (which) {
                                0 -> showEditDialog(usuario, pos)
                                1 -> deleteUser(pos)
                            }
                        }
                        .show()
                }
                true
            }
        }

        private fun showEditDialog(usuario: Usuario, position: Int) {
            val context = itemView.context
            val dialogView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_edit_usuario, null)

            val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
            val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
            val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

            editNombre.setText(usuario.nombre)
            editEdad.setText(usuario.edad.toString())
            editCorreo.setText(usuario.email)

            AlertDialog.Builder(context)
                .setTitle("Editar usuario")
                .setView(dialogView)
                .setPositiveButton("Guardar") { _, _ ->
                    usuario.nombre = editNombre.text.toString()
                    usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                    usuario.email = editCorreo.text.toString()
                    notifyItemChanged(position)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        private fun deleteUser(position: Int) {
            listaUsuarios.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(listaUsuarios[position])
    }

    override fun getItemCount(): Int = listaUsuarios.size

    fun addUser(usuario: Usuario) {
        listaUsuarios.add(usuario)
        notifyItemInserted(listaUsuarios.size - 1)
    }
}
