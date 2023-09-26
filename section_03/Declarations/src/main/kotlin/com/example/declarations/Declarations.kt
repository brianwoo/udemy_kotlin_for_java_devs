package com.example.declarations

import java.lang.StringBuilder

// Define a type alias
typealias EmployeeSet = Set<Employee>


fun main(args: Array<String>) {

    //**** val is a immutable variable
    // We can ignore the actual type when a value is assigned to it
    // An integer is implied
    // val number: Int = 25
    val number = 25


    //**** var is a mutable variable
    var number3: Int
    number3 = 10
    number3 = 20

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    //**** cannot assigned to employee1 because it's a val
    // employee1 = Employee("ERROR here", 100)

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    }
    else {
        employee2 = Employee("Mike Watson", 420)
    }

    //**** Type Alias
    // StringBuilder is a type alias of java.lang.StringBuilder
    val sb = StringBuilder()

    val employees: EmployeeSet

    //**** Collection
    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])

    //**** Handle Equality
    // === NOTE: in Kotlin, == is the same as .equals(), which
    // tests for STRUCTURAL equality. We don't need to call
    // .equals(), just use ==
    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)
    println(employeeOne == employeeTwo)    // false
    println(employeeTwo == employeeThree)  // true

    // .equals() is the same as using ==
    // println(employeeOne.equals(employeeTwo))
    // println(employeeTwo.equals(employeeThree))

    // To check for REFERENTIAL equality, use ===
    println(employeeOne === employeeTwo)    // false
    println(employeeTwo === employeeThree)  // false

    // Test non equals
    var employeeFour = employeeTwo
    println(employeeFour != employeeTwo)    // false
    println(employeeFour !== employeeTwo)   // false
    println(employeeTwo != employeeThree)   // false
    println(employeeTwo !== employeeThree)  // true

    //**** Bitwise OR & AND
    val x = 0x00101101
    val y = 0x11011011
    val xOrY = x or y
    val xAndY = x and y

    //**** instanceof in Java, use "is" in Kotlin or !is for !instanceof
    // casting, use "as"
    val something: Any = employeeFour  // Any can hold any object, sort of like Object
    if (something is Employee) {
        // With Smart Casting, we don't need to cast in Kotlin
        // val newEmployee = something as Employee
        // println(newEmployee.name)
        println(something.name)
    }

    //**** string templates (like Dart's string interpolation)
    val change = 4.22
    println("Value of change, we use \$change, value is: $$change")

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator / $denominator is ${numerator / denominator}")

    //**** Raw strings
    val filePath = """c:\aaa\bbb"""
    val nurseryRhyme = """Humpty Dumpty sat on the wall
       |Humpty Dumpty had a great fall
       |All the king's horses and all the king's men""".trimMargin()
    println(nurseryRhyme)

    //**** REPL
    // Tools -> Kotlin -> Kotlin REPL
}


class Employee(var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }

    //**** $name and $id are string templates
    override fun toString(): String {
        return "Employee(name=$name, id=$id)"
    }


}