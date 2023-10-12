package com.examples.binaryio

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

fun main(args: Array<String>) {

    val di = DataInputStream(FileInputStream("testfile.bin"))
    var si: String

    try {
        while (true) {
            //**** Reading binary files using Java library
            si = di.readUTF()
            println(si)
        }
    }
    catch (e: EOFException) {
        e.printStackTrace()
    }

    //**** Try with Resources in Kotlin is to use one of the "use" functions

}