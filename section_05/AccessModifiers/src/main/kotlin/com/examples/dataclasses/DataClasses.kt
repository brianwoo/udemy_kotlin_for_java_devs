package com.examples.dataclasses


//**** Data classes
//**** Data classes get hashCode(), toString(), equals() and copy() methods for FREE
data class Car(val color: String, val model: String, val year: Int) {

}


class Employee88(val name: String) {

}


fun main(args: Array<String>) {

    val car = Car("blue", "Toyota", 2015)
    //**** printing out data classes looks nicer than regular classes
    // data classes can have custom toString() method as well
    println(car)

    val emp1 = Employee88("John")
    // regular classes will just print the reference
    println(emp1)

    val emp2 = Employee88("John")
    println("Employees equal? ${emp1 == emp2}") // false, when without overriding .equals()

    val car2 = Car("blue", "Toyota", 2015)
    println("Cars equal? ${car == car2}") // true, even when without overriding .equals()

    val car3 = car.copy()
    println(car3)

    //**** copy() with values override
    val car4 = car.copy(year = 2022, color = "white")
    println(car4)
}