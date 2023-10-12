package com.examples.covariance

import javax.swing.plaf.multi.MultiListUI

fun convertToIInt(collection: MutableList<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

fun waterGarden(garden: Garden<Flower>) {
}


open class Flower {

}

class Rose: Flower() {
}

//**** Invariant
// - Invariant wants the exact generic type, if param is Garden<Number>, passing Garden<Int> gives err
// - A "sub" type generic class variable can not be passed to its "super" type as a parameter
// - E.g. Garden<Rose> is passed as a param to a fun myFunc(Garden<Flower>)
// - Solution: Convert the Invariant generic type to a Covariant type
// - Reasoning: Invariant only wants the exact generic type:
//   - There is no chance that a wrong type is passed into an add().
//   - Invariant classes are made READ, WRITE
//   - E.g. MutableList

//**** Covariant
// - Covariant means it can take both generic types: the same type and sub types
// - E.g. It's OK to pass Garden<Rose> as a param to a function myFunc(Garden<Flower>)
// - To convert an Invariant generic type to a Covariant type:
//   - we add "out" keyword to the Invariant generic type
//   - e.g. class Garden<out T: Flower>
// - "out" means MEMBER functions can ONLY return T, not T as an input param
// - Reasoning: Because both generic types can be passed, as a protection feature:
//   - All member functions can not accept this covariant variable as an input param
//   - This covariant variable can only be returned
//   - Covariant classes are made READONLY
//   - E.g. List and ImmutableList
class Garden<out T: Flower> {

    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]

    // T is only for "out"
    // fun plantFlower(flower: T) { }
}



fun main(args: Array<String>) {

    //**** MutableList is Invariant (i.e. want the exact generic supertype)
    //**** List is Covariant (i.e. can accept generic subtypes)
    //**** ImmutableList is Covariant
    val shortsList = mutableListOf<Short>(1,2,3,4,5)
//    convertToIInt(shortsList)

}

