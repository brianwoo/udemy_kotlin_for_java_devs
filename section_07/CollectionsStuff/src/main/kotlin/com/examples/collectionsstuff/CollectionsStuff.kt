package com.examples.collectionsstuff

data class Car(val color: String, val model: String, val year: Int) {}


fun main(args: Array<String>) {

    val intsSet = setOf(10,15,19,5,3,-22)

    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        17 to Car("red", "BMW", 2015),
        8 to Car("green", "Ford", 2010)
    )

    val mutableMap = mutableMapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013)
    )

    //**** filter() method
    println(intsSet.filter { it % 2 != 0 })
    println(immutableMap.filter { it.value.year == 2016 })
    val changedMap = mutableMap.filter { it.value.color == "silver" }
    println(changedMap)

    //**** map() function like in JS
    val ints = arrayOf(1,2,3,4,5)
    val add10List = ints.map { it -> it + 10 }
    println(add10List)

    println(immutableMap.map { it.value.year })

    println(immutableMap
        .filter { it.value.model == "Ford" }
        .map { it.value.color })

    //**** all() - return true if the condition of ALL entries satisfies
    println(immutableMap.all { it.value.year > 2014 })

    //**** any() - return true if the condition of ANY entry satisfies
    println(immutableMap.any { it.value.year > 2014 })

    //**** count() - return the number of conditions satisfies
    println(immutableMap.count { it.value.year > 2014 })

    //**** find() - find a entry with condition in a List
    val cars = immutableMap.values
    println(cars.find { it.year > 2014 })

    //**** groupBy() - group certain entry by a condition, returns a Map
    println(cars.groupBy { it.color })

    //**** toSortedMap() - sort a Map by key
    println(immutableMap.toSortedMap())

    //**** sortedBy() - sort a List by a condition
    println(cars.sortedBy { it.year })
}