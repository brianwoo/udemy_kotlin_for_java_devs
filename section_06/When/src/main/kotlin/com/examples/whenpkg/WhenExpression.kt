package com.examples.whenpkg

import java.math.BigDecimal


enum class Season {
    SPRING, SUMMER, FALL, WINTER
}


fun main(args: Array<String>) {

    //**** "when" in Kotlin is like "switch" in Java
    val num = 20
    val y = 10

    //**** when conditions:
    // comma means OR e.g. x,y
    // in range e.g. x..y
    // expressions e.g. y + 10
    when(num) {
        y + 10 -> println("plus condition")
        100, 200 -> println("200")
        in 201..300 -> println("300")
        else -> println("Doesn't match anything")
    }

    val obj1 = "hello world"
    val obj2 = BigDecimal(25.2)
    val obj3 = 45

    //**** when conditions:
    // Switch between different types e.g. is String
    // When expression can return a value
    val something: Any = obj2
    val z = when(something) {
        is String -> {
            println(something.uppercase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println(something - 22)
            3
        }
        else -> {
            println("Not matching any type")
            -1
        }
    }

    println(z) // 2

    //**** when conditions:
    // Switch between different enums
    val timeOfYear = Season.WINTER
    val str = when(timeOfYear) {
        Season.SPRING -> "Flowers are blooming"
        Season.SUMMER -> "It's hot!"
        Season.FALL -> "It's getting cooler"
        Season.WINTER -> "It's cold!"
    }
    println(str)


    //**** when conditions:
    // Switch between different tests (without a value pass into when)
    val num1 = 10
    val num2 = 20
    when {
        num1 < num2 -> println("num1 is less than num2")
        num1 > num2 -> println("num1 is greater than num2")
        else -> println("num1 and num2 are the same")
    }
}