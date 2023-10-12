package com.examples.lambdas

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {
}

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)
    }
}

fun topLevel() = println("I am a top level function")

fun main(args: Array<String>) {

    //**** Lambdas are written in between a set of {}
    //**** use "run" function to execute a lambda
    //**** "run" can take a function that takes no parameter and returns a Unit
    run { println("I am a lambda") }
    run(::topLevel)

    val employees = listOf(
        Employee("John", "Smith", 2012),
        Employee("Mary", "Johnson", 2015),
        Employee("Jane", "Wilson", 2010),
        Employee("Mike", "Jones", 2002),
        )

    //**** collection.minBy: look for the minimum number
    println(employees.minBy { e -> e.startYear })

    //**** Lambda: using "it" to refer to a parameter passed in.
    //**** "it" is only available if that's the only parameter
    println(employees.minBy { it.startYear })

    //**** Instead of using a lambda, we can use "member reference" as a parameter
    println(employees.minBy(Employee::startYear))



    //**** Lambda can change variables outside of the lambda, unlike in Java
    var num = 10
    run {
        num += 15
        println(num)
    }
}