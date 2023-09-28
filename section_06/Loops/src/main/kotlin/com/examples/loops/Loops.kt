package com.examples.loops

fun main(args: Array<String>) {

    //**** While loop in Kotlin is the same as Java
    //**** For loop in Kotlin is different than in Java

    //**** range operator (range numbers are INCLUSIVE: 1 <= x <= 5)
    val range = 1..5

    //**** range can be for numbers, chars, strings (anything comparable)
    val charRange = 'a'..'z'
    val stringRange = "ABD".."XYZ"

    println(3 in range)               // true
    println('q' in charRange)         // true
    println("CCC" in stringRange)     // true
    println("CCCCCC" in stringRange)  // true because C is less than X
    println("ZZZZZZ" in stringRange)  // false because Z is less than X
    println("ZZZZZZ" !in stringRange) // true (not in)
    println('e' in "Hello")           // true

    //**** Backward range (.downTo())
    val backwardRange = 5.downTo(1)
    println(5 in backwardRange)

    //**** Changing step in range (only for numeric range)
    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    val reversedRange = range.reversed()

    //**** For loop with Range
    for (i in range) {
        println(i)
    }

    for (n in stepThree) {
        println(n)
    }

    //**** string range does NOT work in for loop because we don't know how to loop through strings (no iterator)
    // for (s in stringRange) {}

    val str = "Hello"
    for (c in str) {
        println(c)
    }

    for (i in 1..str.length) {
        println(i)
    }

    for (num in 1..20 step 4) {
        println(num)
    }

    for (i in 20 downTo 1 step 4) {
        println(i)
    }

    //**** "until" keyword (end number is exclusive: 1 <= x < 10)
    for (i in 1 until 10) {
        println(i)
    }


    //**** loop through an array
    val seasons = arrayOf("spring", "summer", "fall", "winter")
    for (season in seasons) {
        println(season)
    }

    //**** loop through an array with indexes
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }

    //**** forEach and forEachIndexed with lambda
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("forEachIndexed: $value is season num $index") }

    //**** named loop (use case: breaking out of nested loop)
    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    break@jloop
                }
            }
        }
    }
}