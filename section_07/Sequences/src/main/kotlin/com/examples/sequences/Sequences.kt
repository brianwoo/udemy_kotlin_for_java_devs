package com.examples.sequences

data class Car(val color: String, val model: String, val year: Int) {}

fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2013),
        17 to Car("red", "BMW", 2015),
        8 to Car("green", "Ford", 2010)
    )

    //**** Collection vs Sequence
    // - Collection:
    //   - Each operation is executed on the entire collection
    //   - New collection is created for each operation
    //   - Should be used on a SMALL data set
    // - Sequence:
    //   - Uses an iterator to pass one element at a time to each intermediate operation
    //   - The same element is then passed to the next operation, ... until reaches the terminal operation
    //   - It then process the next element (remember: it uses an iterator)
    //   - If terminal operation (which does not return a sequence e.g. toList()) is missing at the end,
    //     the sequence operations will NOT be executed
    //   - Sequence can save time when working with a LARGE data set as some condition may end early


    //**** asSequence() - convert a collection to a sequence
    println(immutableMap.asSequence()
        .filter { it.value.model == "Ford" }
        .map { it.value.color })

    val foundName = listOf("Joe", "Mary", "Jane").asSequence()
        .filter { println("filtering $it"); it[0] == 'J' }
        .map { println("mapping $it"); it.uppercase() }
        .find { it.endsWith('E') }

    println("Found name: $foundName")

}