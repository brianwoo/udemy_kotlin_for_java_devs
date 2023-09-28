package com.examples.ifexpression

fun main(args: Array<String>) {

    //**** "if" can be used as a condition or an expression (which can return a value)

    //**** Kotlin does NOT have Ternary operation, instead use the "if" expression
    val someCondition = true
    // num = someCondition ? 50 : 592
    val num = if (someCondition) 50 else 592
    println("num is $num")
}