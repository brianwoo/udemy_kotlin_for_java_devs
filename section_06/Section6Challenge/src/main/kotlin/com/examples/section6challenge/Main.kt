package com.examples.section6challenge

fun main(args: Array<String>) {

    // use a range to print 5, 10, 15, 20, 25, ... 5000
    for (i in 5..5000 step 5) {
        println(i)
    }

    // -500, -499, ... 0
    for (i in -500..0) {
        println(i)
    }

    // print the first 15 numbers in the Fibonacci sequence
    // 0, 1, 1, 2, 3, 5, 8
    var fibonacciNums = arrayOf(0, 1)
    println(fibonacciNums[0])
    println(fibonacciNums[1])
    for (i in 2 until 15) {
        val nextNum = fibonacciNums[i-2] + fibonacciNums[i-1]
        fibonacciNums += nextNum
        println(nextNum)
    }

    // 1, 11, 100, 99, 98, 2
    breakpoint@ for (i in 1..5) {
        println(i)
        if (i == 2) {
            break
        }
        for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) {
                    continue@breakpoint
                }
            }
        }
    }

    // Declare a variable called num (int) and assign it whatever you want
    // Declare a variable called dnum (double) and assign it as follows:
    // if num > 100, assign dnum -234.567
    // if num < 100, assign dnum 4444.555
    // if num == 100, assign dnum 0.0
    // do all of the above in one statement/expression
    // Then print the value of dnum - separate statement
    val num = 1000
    val dnum: Double = if (num > 100) -234.567 else if (num < 100) 4444.555 else 0.0
    println("dnum: $dnum")

    val dnum2 = when {
        num > 100 -> -234.567
        num < 100 -> 4444.555
        else -> 0.0
    }
    println("dnum2: $dnum2")
}