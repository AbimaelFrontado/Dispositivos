import kotlin.random.Random //Importando random
// Primera parte: Evaluación Empleados
fun evaluarEmp() {
    print("Ingrese su salario mensual: ")
    val salario = readln().toDouble()

    print("Ingrese su puntuación (0 - 10): ")
    val puntuacion = readln().toInt()

    var nivel = ""
    var dinero = 0.0

    when (puntuacion) {
        in 0..3 -> {
            nivel = "Inaceptable"
            dinero = salario * (puntuacion / 10.0)
        }
        in 4..6 -> {
            nivel = "Aceptable"
            dinero = salario * (puntuacion / 10.0)
        }
        in 7..10 -> {
            nivel = "Meritorio"
            dinero = salario * (puntuacion / 10.0)
        }
        else -> {
            println("Error: Puntuación fuera de rango.")
            return
        }
    }

    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dinero)}")
}

// Segunda Parte: Piedra, Papel y Tijera
fun ppt() {
    val opciones = listOf("piedra", "papel", "tijera")
    val computadora = opciones[Random.nextInt(opciones.size)]

    print("Elija piedra, papel o tijera: ")
    val usuario = readln().lowercase()
    println("Computadora eligió: $computadora")

    when {
        usuario == computadora -> println("Resultado: Empate")
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel") -> println("Resultado: Ganaste")
        usuario in opciones -> println("Resultado: Perdiste")
        else -> println("Opción inválida ")
    }
}

// Tercera Parte: Calculadora
fun numeros(): Pair<Double, Double> {
    print("Ingrese el primer número: ")
    val a = readln().toDouble()
    print("Ingrese el segundo número: ")
    val b = readln().toDouble()
    return Pair(a, b)
}

fun calculadora() {
    while (true) {
        println("\n==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (readln()) {
            "1" -> {
                val (a, b) = numeros()
                println("Resultado: ${a + b}")
            }
            "2" -> {
                val (a, b) = numeros()
                println("Resultado: ${a - b}")
            }
            "3" -> {
                val (a, b) = numeros()
                println("Resultado: ${a * b}")
            }
            "4" -> {
                val (a, b) = numeros()
                if (b != 0.0) println("Resultado: ${a / b}")
                else println("Error: División entre 0 no permitida")
            }
            "5" -> {
                println("Saliendo de la calculadora ")
                break
            }
            else -> println("Opción inválida ")
        }
    }
}

// Parte Cuatro: Adivinar Número
fun adivinar() {
    val secreto = Random.nextInt(1, 31)
    var intentos = 5

    println("He pensado un número entre 1 y 30. Tienes 5 intentos.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val intento = readln().toInt()

        when {
            intento == secreto -> {
                println("Adivinaste el número.")
                return
            }
            intento < secreto -> println("El número secreto es mayor.")
            else -> println("El número secreto es menor.")
        }
        intentos--
        println("Te quedan $intentos intentos ")
    }

    println("Game Over, el número era $secreto")
}

// Función main
fun main() {
    while (true) {
        println("\n==== Menú Principal ====")
        println("1. Evaluación de Empleados")
        println("2. Piedra, Papel o Tijera")
        println("3. Calculadora")
        println("4. Adivina el Número")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (readln()) {
            "1" -> evaluarEmp()
            "2" -> ppt()
            "3" -> calculadora()
            "4" -> adivinar()
            "5" -> {
                println("Saliendo del programa")
                break
            }
            else -> println("Opción inválida")
        }
    }
}
