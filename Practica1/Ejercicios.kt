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


}
