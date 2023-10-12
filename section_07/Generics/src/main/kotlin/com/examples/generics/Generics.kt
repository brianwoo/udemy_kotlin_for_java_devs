package com.examples.generics

import java.math.BigDecimal

//**** Generics on functions
fun <T> printCollection(collection: List<T>) {
    collection.forEach { println(it) }
}

//**** Generics on extension functions
fun <T> List<T>.printCollection1() {
    this.forEach { println(it) }
}


fun main(args: Array<String>) {

    val list = mutableListOf("Hello")
    list.add("another string")
    printCollection(list)

    val bdList = mutableListOf(
        BigDecimal(-33.45),
        BigDecimal(3503.99),
        BigDecimal(0.329),
    )
    printCollection(bdList)
    bdList.printCollection1()

}