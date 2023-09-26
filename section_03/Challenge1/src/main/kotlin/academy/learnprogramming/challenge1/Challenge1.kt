package academy.learnprogramming.challenge1

fun main(args: Array<String>) {

    // Declaration
    val hello1 = "Hello"
    val hello2 = "Hello"

    // Using one line of code, test whether hello1 and hello2 are referentially equal
    // and print the result
    println(hello1 === hello2)  // true (ref to string pool)

    // Do the same thing as above, but test for structural equality
    println(hello1 == hello2)  // true (same string value)

    // Declare a mutable variable of type int and assign it the value of 2988
    var myVal = 2988

    // Declare an immutable variable of type Any and assign it the string "The Any
    // type is the root of te Kotlin class hierarchy"
    val myAny: Any = "The Any type is the root of te Kotlin class hierarchy"
    if (myAny is String) {
        println(myAny.uppercase())
    }

    // Using one line of code, print out the following.  Make sure your code is
    // nicely indented
    //    1
    //   11
    //  111
    // 1111
    println("""   
        |   1
        |  11
        | 111
        |1111
    """.trimMargin())

    // Bonus
    println("""   
        1   1
        1  11
        1 111
        11111
    """.trimMargin("1"))
}