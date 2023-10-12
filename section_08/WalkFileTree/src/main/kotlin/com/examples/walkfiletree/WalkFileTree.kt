package com.examples.walkfiletree

import java.io.File

fun main(args: Array<String>) {

    //**** Walking file tree
    //- walkTopDown() returns a sequence
    //- walkBottomUp() returns a sequence
    //- walk(), specify a direction, returns a sequence
    File(".").walkTopDown()
        .filter { it.name.endsWith(".kt") }
        .forEach { println(it) }
}