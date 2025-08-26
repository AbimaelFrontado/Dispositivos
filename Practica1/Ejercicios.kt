//Primera parte: Evaluación Empleados

fun EvaluarEmp() {
    print("Ingrese su salario mensual: ")
    val salario = readln().toDouble() //Leer la entrada y convertirla a double 

    print("Ingrese su puntuación (0 - 10): ")
    val puntuacion = readln().toInt() //leear la entrada y convertirla a int

    var nivel = ""
    var dinero = 0.0

    when (puntuacion) { //Especie de switch case con intervalos 
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

//Segunda Parte: Piedra, Papel y Tijera

fun PPT() {
    val opciones = listOf("piedra", "papel", "tijera")
    val computadora = opciones[Random.nextInt(opciones.size)] //tomando una posicion random del 0 al 2 y el valor de la lista se agrega a la varibale

    print("Elija piedra, papel o tijera: ")
    val usuario = readln().lowercase()   //leyendo y transformando a minúsculas
    println("Computadora eligió: $computadora")

    when {
        usuario == computadora -> println("Resultado: Empate")
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel") -> println("Resultado: Ganaste")
        usuario in opciones -> println("Resultado: Perdiste")
        else -> println("Opción inválida.")
    }
}

//Tercera Parte: Calculadora 

fun Numeros(): Pair<Double, Double> { //función auxiliar para la calculadora
    print("Ingrese el primer número: ")
    val a = readLine().toDouble()  
    print("Ingrese el segundo número: ")
    val b = readLine().toDouble()
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

        when (readLine()) {
            "1" -> {
                val (a, b) = Numeros()
                println("Resultado: ${a + b}")
            }
            "2" -> {
                val (a, b) = Numeros()
                println("Resultado: ${a - b}")
            }
            "3" -> {
                val (a, b) = Numeros()
                println("Resultado: ${a * b}")
            }
            "4" -> {
                val (a, b) = Numeros()
                if (b != 0.0) println("Resultado: ${a / b}")
                else println("Error: División entre 0 no permitida")
            }
            "5" -> {
                println("Saliendo de la calculadora...")
                break
            }
            else -> println("Opción inválida.")
        }
    }
}


//Parte Cuatro: Adivinar Número 

fun adivinar() {
    val Secreto = Random.nextInt(1, 31) //Se Genera un número 
    var intentos = 5

    println("He pensado un número entre 1 y 30. Tienes 5 intentos.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val intento = readLine().toInt() 
        
        when {
            intento == numeroSecreto -> {
                println("  Adivinaste el número.")
                return
            }
            intento < numeroSecreto -> println("El número secreto es mayor.")
            else -> println("El número secreto es menor.")
        }
        intentos--
        println("Te quedan $intentos intentos ")
    }

    println("Game Over, el número era $Secreto")
}

//función main 
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
            "1" -> EvaluarEmp()
            "2" -> PPT()
            "3" -> calculadora()
            "4" -> adivinar()
            "5" -> {
                println("Saliendo del programa ")
                break
            }
            else -> println("Opción inválida ")
        }
    }

 
