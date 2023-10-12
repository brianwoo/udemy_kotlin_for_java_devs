package com.examples.contravariance

import java.util.concurrent.Flow

open class Flower(val name: String) {

}

class Rose: Flower("Rose") {
}

class Daffodil: Flower("Daffodil") {
}

//**** Contravariance
// - the opposite of the Covariance
//   - We start with a class of Sub type E.g. Garden<Rose>
//   - where the Garden<Rose> can accept both ITSELF and the Super type E.g. Garden<Flower>
//   - We are looking at "UP" the inheritance tree

// Quick recap (Declaration site variance):
//**** Contravariance
// Garden<Rose>, can accept ITSELF and UP the inheritance tree
// Use "in" keyword - input params only
// Remember: Contravariance - Up - in
//**** Covariance
// Garden<Flower>, can accept ITSELF and DOWN the inheritance tree
// Use "out" keyword - return type only
// Remember: Covariance - Down - out

class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

interface FlowerCare<in T> {
    fun prune(flower: T)
}


fun main(args: Array<String>) {

    // FLOWER
    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm pruning a ${flower.name}!")
    }

    // ROSE
//    val roseTender = object: FlowerCare<Rose> {
//        override fun prune(flower: Rose) = println("I'm pruning a rose!")
//    }

    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), flowerTender)
//    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)


    // DAFFODIL
//    var daffodilTender = object: FlowerCare<Daffodil> {
//        override fun prune(flower: Daffodil) = println("I'm pruning a daffodil!")
//    }
    val daffodilGarden = Garden<Daffodil>(
        listOf(Daffodil(), Daffodil(), Daffodil()),
        flowerTender)

    daffodilGarden.tendFlower(2)
}