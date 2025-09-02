//  Crear una clase abstracta “shape” la cual contenga las propiedades área, perímetro. Adicional crea tres subclases cuadrado, círculo y rectángulo que reciban los valores de sus lados, el radio en el caso del círculo con constructores secundarios y heredando la clase “shape” y sus métodos.
// Abimael Ernesto Frontado Fajardo
// 30/08/2025
//Última modificación: 02/09/2025

abstract class Shape {
    var area: Double = 0.0
    var perimetro: Double = 0.0

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun resultados() {

        println("Área: $area")
        println("Perímetro: $perimetro")
        println("-------------")

    }
}

class Cuadrado(private val lado: Double) : Shape() {

    constructor(lado: Int) : this(lado.toDouble())

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }

}

class Rectangulo(private val base: Double, private val altura: Double) : Shape() {

    //Implementación para que acepte int o double en cada uno de sus atributos
    constructor(base: Int, altura: Int) : this(base.toDouble(), altura.toDouble())
    constructor(base: Double, altura: Int) : this(base , altura.toDouble())
    constructor(base: Int, altura: Double) : this(base.toDouble(), altura )

    override fun calcularArea() {

        area = base * altura

    }

    override fun calcularPerimetro() {

        perimetro = 2 * (base + altura)

    }
}

class Circulo(private val radio: Double) : Shape() {

    constructor(radio: Int) : this(radio.toDouble())

    override fun calcularArea() {

        area = Math.PI * radio * radio

    }

    override fun calcularPerimetro() {

        perimetro = 2 * Math.PI * radio

    }
}

// Programa principal
fun main() {

    val cuadrado = Cuadrado(5.3)
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    println("Cuadrado:")
    cuadrado.resultados()

    val rectangulo = Rectangulo(4 , 6.7 )
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    println("Rectángulo:")
    rectangulo.resultados()

    val circulo = Circulo(7 )
    circulo.calcularArea()
    circulo.calcularPerimetro()
    println("Círculo:")
    circulo.resultados()

}
