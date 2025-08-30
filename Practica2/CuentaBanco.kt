// Diseñar una clase CuentaBancaria que tenga un saldo y un límite de retiro. Implementa métodos set y get para establecer y obtener el saldo, y añade un metodo para realizar retiros
//Abimael Ernesto Frontado Fajardo
// 30/08/2025
//Última modificación: 30/08/2025
class CuentaBancaria(n1: Double, n2: Double ) {

     private var saldo: Double = 0.0
     private var limiteRetiro: Double = 0.0

     fun realizarRetiro(n1: Double ) {
         if (n1 > saldo) {
             println("Saldo insuficiente")

         }else if (n1>limiteRetiro ) {
             println("Limite de retiro: $limiteRetiro ")
         }else {
             saldo -= n1
         }
     }
     fun SetSaldo(n1: Double ) {
         if(n1>=0){
             saldo = n1
             println("Saldo: $saldo")
         }else{
             println("No existe saldo negativo")
         }
     }
     init{
         this.saldo = n1
         this.limiteRetiro = n2
     }
    fun getSaldo() = saldo
 }
fun main() {
    val c = CuentaBancaria(1000.0,500.0)
    c.SetSaldo(2000.0)
    c.realizarRetiro(1000.0) //Retiro mayor al límite
    c.realizarRetiro(500.0)
    println("Saldo actual = ${c.getSaldo()}")
    c.SetSaldo(300.00)
    c.realizarRetiro(400.0) //Retiro mayor al saldo

}
