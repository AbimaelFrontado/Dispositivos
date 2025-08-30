// Diseñar una clase Producto que tenga un precio y un descuento aplicable. Implementa métodos set y get para establecer y obtener el precio y el descuento, y añade un metodo para calcular el precio final
// Abimael Ernesto Frontado Fajardo
// 30/08/2025
//Última modificación: 30/08/2025

class Producto( ) {

    private var precio: Double = 0.0
    private var descuento : Double = 0.0

    fun setPrecio(n1: Double){

        if(n1> 0){
            precio = n1
        }else{
            println("El precio no puede ser negativo ni cero")
        }

    }
    fun getPrecio() = precio

    fun setDescuento( ){

        println("Elija una de las opciones de descuento")
        println("1 = 10%")
        println("2 = 20%")
        println("3 = 50%")
        println("4 = 90%")

        val opcion = readln()

        when(opcion){

            "1" -> descuento = 0.9
            "2" -> descuento = 0.8
            "3" -> descuento = 0.5
            "4" -> descuento = 0.1
            else ->  println("Opcion invalida")

        }
    }

    fun getDescuento() = descuento

    fun precioFinal( ){

        var final: Double

        if(descuento > 0.0 ){

            final =  precio*descuento
            println("Precio total = $final")
        }else{
            println("Precio total  = $precio")
        }

    }

}
fun main() {
    val producto = Producto()
    producto.setPrecio(10.0)
    producto.precioFinal()
    producto.setDescuento()
    producto.precioFinal()

}
