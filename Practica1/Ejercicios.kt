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

 
