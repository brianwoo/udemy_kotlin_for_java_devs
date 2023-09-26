package com.examples.functions

fun main(args: Array<String>) {

    //**** Calling the function with position arguments
    println(labelMultiply(3,4,"The result is:"))
    //**** Calling the function with named arguments
    println(labelMultiply(label = "The result is:", operand1 = 3, operand2 = 4))

    val emp = Employee("Jane")
    println(emp.upperCaseFirstname())



    //**** if vararg is the first arg, we need to use named arg after the vararg
    printColors(
        Car("blue", "Toyota", 2012),
        Car("red", "Lexus", 2017),
        Car("white", "Ford", 2012),
        anotherParam = "Just another string"
    )

    val manyCars = arrayOf(
        Car("blue", "Toyota", 2012),
        Car("red", "Lexus", 2017),
        Car("white", "Ford", 2012)
    )

    val manyCars2 = arrayOf(
        Car("gold", "Tesla", 2010),
        Car("silver", "Benz", 2013),
        Car("brown", "Lambo", 2011)
    )

    //**** Spread operator (*), unpacking array -> vararg
    // unlike Java where array can be passed to vararg operator
    //**** Combine arrays and items into a single array
    val lotsOfCars = arrayOf(*manyCars, *manyCars2, Car("green", "Nissan", 1998))
    for (car in lotsOfCars) {
        println("lotsOfCars: $car")
    }

    // Calling extension function
    println("this is all in lowercase".upperFirstAndLast())
}

//**** extension function
// creating in illusion that this has been added to the String class
// use "this" to get a hold of the String (which is called the Receiver Type)
// This is similar to GoLang
// Use case: Like static helper methods in Java
fun String.upperFirstAndLast(): String {
    val upperFirst = substring(0, 1).uppercase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}

//**** inline function
// Compiler will optimize the bytecode to have the body of this function inline where it is called
// instead of a separate function. *Might give performance gain or negative impact*
inline fun inlineFunc() { }


//**** Regular function with {} is called a Block body

//**** Simplified function with 1 line in return, use the equals sign (aka an Expression Body)
fun labelMultiply(operand1: Int, operand2: Int, label: String) = "$label ${operand1 * operand2}"

//**** vararg keyword to specified variable arguments, like ... var in Java
//**** Can only use one vararg signature
fun printColors(vararg cars: Car, anotherParam: String) {
    for (car in cars) {
        println(car)
    }
}


class Employee(val firstName: String) {

    fun upperCaseFirstname() = firstName.uppercase()
}

data class Car(val color: String, val model: String, val year: Int) {

}