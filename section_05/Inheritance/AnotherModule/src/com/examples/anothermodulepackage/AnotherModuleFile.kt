package com.examples.anothermodulepackage

//**** Kotlin module and dependency
// To use a function from another module, add this module as a dependency
import com.examples.inheritance.CompanyCommunications
import com.examples.inheritance.topLevel
import com.examples.inheritance.uselessFeature as uf

fun main(args: Array<String>) {
    topLevel("Hello from another module")
    println("blahblah".uf())
}