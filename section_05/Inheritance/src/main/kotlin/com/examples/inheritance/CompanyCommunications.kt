package com.examples.inheritance

import java.time.Year

//**** "object" keyword (Singleton)
//**** "object" - no constructor needed
// object declaration declares and create at the same time,
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"

    //**** "internal" method can only be used in the SAME module
    internal fun getCopyrightLine() = "Copyright \u00a9. All rights reserved"
}

//**** private constructor
class SomeClass private constructor(val someString: String) {

//    private constructor(something: String, aaaa: Boolean): this(something) {}

    //**** "companion object" - like static var and method in Java
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        //**** Using companion object to implement factory method pattern
        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            if (lowerCase) {
                return SomeClass(str.lowercase())
            }
            else {
                return SomeClass(str.uppercase())
            }
        }
    }
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface: ${si.mustImplement(22)}")
}

//**** enum is a class in Kotlin
enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5),
    IT("Information Technology", 2),
    ACCOUNTING("Accounting", 6),
    SALES("Sales", 10);

    //**** enum methods
    fun getDeptInfo() = "The $fullName dept has $numEmployees employees"
}

fun String.uselessFeature() = "This is a useless feature: $this"


fun main(args: Array<String>) {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())
    println(SomeClass.accessPrivateVar())

    val someClass1 = SomeClass.justAssign("justAssign")
    val someClass2 = SomeClass.upperOrLowerCase("upperOrLowerCase", false)
    println("someClass1: ${someClass1.someString}")
    println("someClass2: ${someClass2.someString}")

    var thisIsMutable = 45

    //**** "object" - for implementing an anonymous object
    //**** anonymous object is NOT a singleton
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            return "this is from mustImplement: ${num * thisIsMutable}"
        }
    })

    println(Department.ACCOUNTING.getDeptInfo())
}
