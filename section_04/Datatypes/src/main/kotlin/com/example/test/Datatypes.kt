package com.example.test

import com.example.javacode.DummyClass
import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {

    //**** Kotlin has no primitive types, all types are Object types (caps)

    //**** Integers
    // (If no explicit type set, Int is default for non-decimal numbers)
    val myInt = 10
    println("Default dataType is Int? ${myInt is Int}")

    //**** Double
    // (If no explicit type set, Double is default for decimal numbers)
    var myDouble = 65.984
    println("Default dataType is Double? ${myDouble is Double}")

    //**** Long
    var myLong = 22L
    val myLong1: Long = 22

    //**** Assigning Int to Long (Kotlin does NOT auto widen)
    myLong = myInt.toLong()

    // Similarly Byte to Short
    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort()

    val myFloat = 838.222F
    println("This is a float? ${myFloat is Float}")
    myDouble = myFloat.toDouble()

    //**** Char
    var myChar = 'b'
    val myChar2: Char = 65.toChar()
    println("myChar2 is $myChar2")

    //**** Boolean
    val myBoolean = true

    val vacationTime = false
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println(onVacation)

    //**** Any class
    val anything: Any

    //**** Array
    // Array of Strings
    val names = arrayOf("John", "Jane", "Jill", "Joe")

    // Array of Longs (2 options)
    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3)
    println("Array of Longs? ${longs1 is Array<Long>}")
    println("Array of Longs? ${longs2 is Array<Long>}")

    // Array of Int
    val ints1 = arrayOf(1, 2, 3)
    println("Array of Ints? ${ints1 is Array<Int>}")

    // Array indexing
    println("Index at 2: ${longs1[2]}")

    // Initializing an array with a initializing Lambda
    // Size of 16, Lambda: every index * 2
    val evenNumbers = Array(16) { i -> i * 2 }
    println("evenNumbers: ${evenNumbers.contentToString()}")

    for (number in evenNumbers) {
        println("Each evenNumber: $number")
    }

    val arrayStartsWithOne = Array(100) { i -> i + 1 }
    val allZeroes = Array(100) { 0 }

    // Create an array but no initial values
    var arrayWithValuesLater: Array<Int>
    arrayWithValuesLater = arrayOf(1,2,3,4)
    arrayWithValuesLater = Array(3) {i -> i + 1}

    // Array of mixed types
    val mixedArray = arrayOf("hello", 22, BigDecimal.TEN, 'a')
    println("mixedArray is Array<Any>? ${mixedArray.isArrayOf<Any>()}")

    //**** Java int[] vs Kotlin IntArray vs Kotlin Array
    // Java int[] does NOT equal to Kotlin Array<Int>
    // Java int[] equals IntArray in Kotlin
    // DummyClass().printNumbers(arrayOf(3, 6, 9))
    DummyClass().printNumbers(intArrayOf(3, 6, 9))
    DummyClass().printNumbers(arrayOf(3, 6, 9).toIntArray())

    // NOTE: IntArray (which is int[]) can be initialized with size
    // this will be the same in Java: int[5] = {0,0,0,0,0}
    var okArray = IntArray(5)
    // NOTE: Array can NOT be initialized with size, and no initial values
    // var failedArray = Array(5)

    //**** Convert Kotlin IntArray to Kotlin Array
    val convertedIntArray: Array<Int>
    convertedIntArray = okArray.toTypedArray()
}