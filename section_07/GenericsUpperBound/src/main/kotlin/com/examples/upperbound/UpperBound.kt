package com.examples.upperbound

import java.lang.StringBuilder


//**** Generic type but only subclass of Number (setting upper bound)
//**** Nullable Upper bound is set by adding "?"
fun <T: Number?> convertToInt(collection: List<T>) {
    println(collection.joinToString(", "))
}

//**** where keyword: to set multiple generics upper bound
fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
    println("Result is ${item1.append(item2)}")
}

//**** Generic type is "nullable Any" by default
//**** To restrict "non-nullable Any", we just do <T: Any>
fun <T> printCollection(collection: List<T>) {
    println(collection.joinToString(", "))
}


fun main(args: Array<String>) {

    val ints = listOf(1,2,3,4,5)
    val shorts: List<Short?> = listOf(10,20,30,40)
    val floats: List<Float?> = listOf(100.30f, -459.43f)
    val strings = listOf("1", "2", "3")

    convertToInt(ints)
    convertToInt(shorts)
    convertToInt(floats)
//    convertToInt(strings)

    append(StringBuilder("String 1"), StringBuilder("String 2"))

    printCollection(shorts)
    printCollection(strings)

    //**** Using "is" in Kotlin (instanceof)
    //**** Kotlin is similar to Java where generic types are erased
    if (strings is List<String>) {
        println("This list contains strings")
    }

    val listAny: Any = listOf("str1", "str2", "str3")
    //**** To type check generic types, we have to use <*> (star projection)
    if (listAny is List<*>) {
        println("Yes, this is a list. Thank you star projection!")
        val strList = listAny as List<String>
        println(strList[1].replace("str", "STR"))
    }

}