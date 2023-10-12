package com.examples.maps

class Car(val color: String, val model: String, val year: Int) {

    //**** To be able to de-structure a class, we need to add a "Component Function"
    // which does NOT come for FREE
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}


data class Truck(val color: String, val model: String, val year: Int) {

    //**** data classes come with "Component Functions" for FREE
}


fun main(args: Array<String>) {

    //**** Like Lists, there is a mutable and an immutable version
    //**** mapOf() produces an immutable Map
    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2016)
    )
    println(immutableMap.javaClass)
    println(immutableMap)

    //**** mutableMapOf() produces a mutable Map
    val mutableMap = mutableMapOf<String, Car>(
        "John's car" to Car("red", "Range Rover", 2010),
        "Jane's car" to Car("blue", "Hyundai", 2012)
    )
    println(mutableMap.javaClass)
    println(mutableMap)

    //**** hashMapOf() produces a mutable Map
    val mutableHashMap = hashMapOf<String, Car>(
        "John's car" to Car("red", "Range Rover", 2010),
        "Jane's car" to Car("blue", "Hyundai", 2012)
    )
    println(mutableHashMap.javaClass)
    mutableHashMap.put("Mary's car", Car("red", "Corvette", 1977))
    println(mutableHashMap)

    //**** Pair
    val pair = Pair(10, "ten")
//    val firstValue = pair.first
//    val secondValue = pair.second

    //**** destructuring operation, like in Javascript
    val (firstValue, secondValue) = pair

    //**** destructuring a map's key,value in a loop
    for ((k, v) in mutableHashMap) {
        println("key: $k, value: $v")
    }

    // Destructuring a regular object
    val car = Car("blue", "Corvette", 1775)
    val (color, model, year) = car
    println("color, model, year = {$color, $model, $year}")

    val truck = Truck("Black", "Toyota", 2014)
    val (truckColor, truckModel, truckYear) = truck
    println("truckColor, truckModel, truckYear = {$truckColor, $truckModel, $truckYear}")
}