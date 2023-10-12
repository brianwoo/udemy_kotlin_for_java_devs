package com.examples.usesitevariance

open class Car {
}

class Toyota: Car() {
}

class Ford: Car() {
}

fun <T: Car> copyCars(src: MutableList<out T>, dest: MutableList<T>) {
    for (car in src) {
        dest.add(car)
    }
}

//**** Generic classes are invariant by default
//**** Use site Covariance / Contravariance
// - It's used at the function that's being referenced, not at the class declaration
// - It's used when the class cannot be changed to co or contra variant
// - Use site Contravariance
//   - E.g. in Java: List<? super Car>    --> Ford and UP inheritance tree
// - Use site Covariance
//   - E.g. in Java: List<? extends Car>  --> Car and DOWN inheritance tree

fun main(args: Array<String>) {

    val cars1 = mutableListOf(Car(), Car())
    val cars2 = mutableListOf<Car>()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2 = mutableListOf<Ford>()
    copyCars(fords1, fords2)

    val cars3: MutableList<Car> = mutableListOf()
    copyCars(fords1, cars3)
}