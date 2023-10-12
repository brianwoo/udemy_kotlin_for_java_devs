package com.examples.iokotlin

import java.io.File

fun main(args: Array<String>) {
    //**** Reader.readLines() automatically closes the reader when done
    val lines1 = File("testfile.txt").reader().readLines()
    lines1.forEach { println("Reader.readlines: $it") }

    //**** Reader.readText() needs closing reader explicitly
//    val reader = File("testfile.txt").reader()
//    val lines2 = reader.readText()
//    println(lines2)
//    reader.close()

    //**** Reader.use() function - a closeable function even if exception thrown
    //**** Tip: functions with "use" in its name mean it does auto close
    val lines2 = File("testfile.txt").reader().use { it.readText() }
    println("Reader.readText: $lines2")


    //**** File.readText() automatically closes the reader when done
    val lines3 = File("testfile.txt").readText()
    println("File class: $lines3")

    //**** Reader.readLines(), Reader.readText(), Reader.use(), File.readText()
    // - Read all lines into memory. Not recommended if file is BIG

    //**** use forEachLine to read BIG files
    File("testfile.txt").forEachLine { println("One line at a time: $it") }

    File("testfile.txt").useLines { it.forEach { println("useLines: $it") }  }
}