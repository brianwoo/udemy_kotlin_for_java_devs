package com.examples.sets

fun main(args: Array<String>) {

    //**** setOf() produces an immutable set
    val intsSet = setOf(10,15,19,5,3,-22)
    //**** plus(), minus(), average(), drop() methods
    println(intsSet.plus(20))
    //**** Set will ignore duplicate elements
    println(intsSet.plus(10))
    println(intsSet.minus(19))
    println(intsSet.minus(100))
    println(intsSet.average())
    println(intsSet.drop(3))

    //**** mutableSetOf() produces a mutable set
    val mutableIntsSet = mutableSetOf(1,2,3,4,5)
    //**** plus() returns a new immutable set vs add() adds to mutable set
    mutableIntsSet.plus(10)
    println(mutableIntsSet)
    mutableIntsSet.add(10)
    println(mutableIntsSet)
}