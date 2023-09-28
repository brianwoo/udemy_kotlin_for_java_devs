package com.examples.trycatch

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

//**** Kotlin doesn't distinguish between checked and unchecked exceptions
fun getNumber(str: String): Int? {

    //**** try-catch can be an expression and return a value
    return try {
            Integer.parseInt(str)
        }
        catch (e: NumberFormatException) {
            null
        }
        finally {
            //**** finally cannot return a value
            println("in finally block")
        }
}

//**** Nothing return type to indicate it won't return
fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("Implement me!")
}


fun main(args: Array<String>) {

    println(getNumber("22.2") ?: "I can't print the result")
    println(getNumber("22.2") ?: throw IllegalArgumentException("str isn't a Int"))

    notImplementedYet("aaa")
    //**** because of Nothing return type, following line is not reachable
    println("aaa")


}