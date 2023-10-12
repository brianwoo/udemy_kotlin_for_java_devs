package com.examples.collections

fun main(args: Array<String>) {

    //**** Collection
    //**** listOf() produces an immutable list in Kotlin
    //**** List is immutable
    val strings = listOf("spring", "summer", "fall", "winter")

    //**** Tip: use yourObject.javaClass to find out what Java class it is
    println(strings.javaClass)  // java.util.Arrays$ArrayList

    //**** emptyList
    val emptyList = emptyList<String>()
    println(emptyList.javaClass)  // kotlin.collections.EmptyList
    println("emptyList is empty? ${emptyList.isEmpty()}")

    //**** listOfNotNull - a list that will not hold null
    val notNullList = listOfNotNull("hello", null, "good bye")
    println(notNullList) // null item got dropped

    //**** arrayListOf produces a mutable list in Kotlin
    //**** ArrayList is mutable
    val arrayList = arrayListOf(1,2,3)
    println(arrayList.javaClass)    // java.util.ArrayList
    arrayList.add(4)

    val mutableList = mutableListOf<Int>(1,2,3)
    println(mutableList.javaClass)  // java.util.ArrayList

    //**** Convert array to list
    val array = arrayOf("red", "blue", "yellow")   // created String[]
    val colorList = listOf(*array)
    //**** array.toList() produces the same list as listOf(*array)
    println(colorList)

    // int[] to Kotlin List
    val ints = intArrayOf(1,2,3,4)
    println(ints.toList())

    val kotlinArray = arrayOf(1,2,3,4)
    println(kotlinArray)

}