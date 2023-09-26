package com.examples.inheritance

//**** In Kotlin, all functions and classes are public and final by default
// Meaning, we cannot extend this class by default
// To make it extendable / overridable, use the "open" keyword
open abstract class Printer(val modelName: String) {

    // open, so overridable
    open fun printModel() = println("parent class model name is: $modelName")

    //**** abstract method
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int): Printer(modelName), MyInterface {

    // overriding the abstract function
    override fun bestSellingPrice(): Double = 129.99

    override val number: Int = 333

    //**** "override" key word to override
    //**** "override" implicitly means "open"
    //**** "final" will stop this method being overridable
    final override fun printModel() = println("child class model name is: $modelName")

    override fun myFunction(str: String): String = str
}

class SpecialLaserPrinter(): LaserPrinter("Special", 999) {
    // cannot override a final method
    // override fun printModel() = println("")


}

open class Something: MySubInterface {
    val someProperty: String

    override val number: Int = 25

    constructor(someParam: String) {
        someProperty = someParam
        println("In parent's constructor")
    }

    //**** overriding interface methods
    override fun myFunction(str: String): String = "aaaa"
    override fun mySubFunction(str: String): String = "bbbb"
}

class SomethingElse: Something {

    //**** Sub-classing and with only secondary constructor
    //**** "super" keyword to refer to the super-class
    constructor(someOtherParam: String): super(someOtherParam) {
        println("In child's constructor")
    }
}

//**** data classes cannot be "open" (not extendable)
data class DataClass(val number: Int) {}

//**** interface in Kotlin is pretty much the same as Java
//**** interfaces do not need to be set "open" to be extendable
//**** Note: interface in Kotlin can have member variables (becomes abstract properties)
//**** Note: interface in Kotlin can have default value, but have to define a getter method for it
interface MyInterface {

    val number: Int

    val number2: Int
        get() = number * 3

    fun myFunction(str: String): String
}

interface MySubInterface: MyInterface {
    fun mySubFunction(str: String): String
}


fun main(args: Array<String>) {

    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()
    laserPrinter.bestSellingPrice()

    var something = SomethingElse("Blah")
}