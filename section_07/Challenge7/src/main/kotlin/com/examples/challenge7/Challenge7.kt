package com.examples.challenge7

class Person(val firstName: String, val lastName: String, val age: Int) {

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}

class Box<out T> {
    
}

open class Paper {
}

class Regular: Paper() {
}

class Premium: Paper() {
}


fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName, age = $age")

    val people = mapOf(
        joe.lastName to joe,
        jane.lastName to jane,
        mary.lastName to mary,
        john.lastName to john,
        jean.lastName to jean
    )

    val lastNameStartsWithS = people.count { it.value.lastName.startsWith('S') }
    println("lastName starts with S: $lastNameStartsWithS")

    val namePairs = people.map { it -> Pair(it.value.firstName, it.value.lastName) }
    println(namePairs)

    // also()
    // print the following:
    // Joe is 45 years old
    // Jane is 12 years old
    // etc.
//    people.forEach { s, person -> person.also { println("${it.firstName} is ${it.age} years old") }  }
    people.also {
        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
    }

    val list1 = listOf(1,4,9,15,33)
    val list2 = listOf(4,55,-83,15,22,101)

    val dupList = list1.intersect(list2).toList()
    println(dupList)

    // Or do this:
    val dupList2 = list1.filter{ it in list2 }
    println(dupList2)


    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper
}