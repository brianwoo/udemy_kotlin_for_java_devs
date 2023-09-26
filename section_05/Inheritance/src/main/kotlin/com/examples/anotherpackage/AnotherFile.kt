package com.examples.anotherpackage

//**** "as" keyword
import com.examples.inheritance.CompanyCommunications as Comm
import com.examples.inheritance.Department
import com.examples.inheritance.topLevel as tp

fun main(args: Array<String>) {
    tp("From AnotherFile")
    println(Comm.getCopyrightLine())
    println(Department.IT.getDeptInfo())
}