//  Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces
// Abimael Ernesto Frontado Fajardo
// 30/08/2025
//Última modificación: 02/09/2025

abstract class Material( val titulo: String, val autor: String,  val anioPublicacion: Int) {

    abstract fun mostrarDetalles()

}

class Libro( titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)  : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {

        println("📘 Libro: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("Género: $genero")
        println("Páginas: $numeroPaginas")
        println("----------------------")

    }

}

class Revista( titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int,  val editorial: String) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {

        println("📖 Revista: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen, Número: $numero")
        println("Editorial: $editorial")
        println("----------------------")

    }

}

data class Usuario( val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {

    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material): Boolean
    fun devolucion(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)

}

class Biblioteca : IBiblioteca {

    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()
    private val usuarios = mutableListOf<Usuario>()

    override fun registrarMaterial(material: Material) {

        materialesDisponibles.add(material)

    }

    override fun registrarUsuario(usuario: Usuario) {

        usuarios.add(usuario)
        prestamos[usuario] = mutableListOf()

    }

    override fun prestamo(usuario: Usuario, material: Material): Boolean {

        if (materialesDisponibles.contains(material) && usuarios.contains(usuario)) {

            materialesDisponibles.remove(material)
            prestamos[usuario]!!.add(material)
            println(" Prestamo realizado: '${material.titulo}' a ${usuario.nombre}")
            return true

        }

        println(" No se pudo realizar el préstamo ")
        return false

    }

    override fun devolucion(usuario: Usuario, material: Material): Boolean {

        if (prestamos[usuario]!!.contains(material) == true) {

            prestamos[usuario]!!.remove(material)
            materialesDisponibles.add(material)
            println(" Devolución realizada: '${material.titulo}' por ${usuario.nombre}")
            return true

        }

        println(" No se pudo realizar la devolución.")
        return false

    }

    override fun mostrarMaterialesDisponibles() {

        println("  Materiales disponibles:")

        if (materialesDisponibles.isEmpty()) {

            println("No hay materiales disponibles.")

        } else {

            materialesDisponibles.forEach { it.mostrarDetalles() }

        }

    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {

        println(" Materiales reservados por ${usuario.nombre}:")
        val reservados = prestamos[usuario]

        if (reservados.isNullOrEmpty()) {

            println("No tiene materiales en préstamo ")

        } else {

            reservados.forEach { it.mostrarDetalles() }

        }

    }

}

fun main() {

    val biblioteca = Biblioteca()

    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val libro2 = Libro("El Quijote", "Miguel de Cervantes", 1605, "Novela", 863)
    val revista1 = Revista("National Geographic", "Varios", 2023, "1234-5678", 12, 5, "NatGeo")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    val usuario1 = Usuario("Ana", "Pérez", 25)
    val usuario2 = Usuario("Luis", "García", 30)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestamo(usuario1, libro1)
    biblioteca.prestamo(usuario2, revista1)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)

    biblioteca.devolucion(usuario1, libro1)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    
}
