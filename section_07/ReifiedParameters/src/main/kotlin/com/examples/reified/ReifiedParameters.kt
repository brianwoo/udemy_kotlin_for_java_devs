package com.examples.reified

import java.math.BigDecimal


//**** To get around the type being "erased" in collections, we can use Reified Type
//**** Need to do 2 things:
//     - Set the function as inline
//     - Set the generic type as <reified T>
//**** Reified is only useful if we need to check a generic type inside a function
//**** Only inline functions can be reified
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {

    var newList: MutableList<T> = mutableListOf()
    for (element in list) {
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}

fun main(args: Array<String>) {

    val mixedList: List<Any> = listOf(
        "string", 1, BigDecimal(22.5), "fall", BigDecimal(-283.2))
    val bigDecimalsOnly = getElementsOfType<BigDecimal>(mixedList)
    for (item in bigDecimalsOnly) {
        println(item)
    }
}