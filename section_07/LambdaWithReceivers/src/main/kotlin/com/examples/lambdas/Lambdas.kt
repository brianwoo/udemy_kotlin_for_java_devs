package com.examples.lambdas

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {
}

// CountTo100 long way for comparison
fun countTo100Original(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

fun countTo100UsingWith(): String {
    val numbers = StringBuilder()

    //**** "with" function takes:
    // 1. parameter (aka a receiver)
    // 2. a lambda (last arg, which we can write it as {})
    // 3. return a value
    //**** Shortcut: when using "with", the "receiver" inside the lambda can be ignored
    //**** Shortcut: or use "this" to refer to the receiver
    //**** Shortcut: last line in the lambda is automatically returned (don't need return)
    return with(numbers) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}

fun countTo100UsingApply(): String {
    val numbers = StringBuilder()

    //**** "apply" function takes:
    // 1. a lambda (last arg, which we can write it as {})
    // 2. return the receiver
    numbers.apply() {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
    return numbers.toString()
}

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach {
        if (it.lastName == lastName) {
            println("Yes, found employee with lastName: $lastName")
            //**** non-local return, meaning, it returns from lambda and the enclosing function
            return
        }
    }

    //**** for local return, meaning, it returns from lambda only, use a label
    employees.forEach returnBlock@ {
        //...
        return@returnBlock
    }

    println("Nope, there is no employee with the lastName: $lastName")
}


fun main(args: Array<String>) {

    println(countTo100UsingWith())
    println(countTo100UsingApply())

    val employees = listOf(
        Employee("John", "Smith", 2012),
        Employee("Mary", "Johnson", 2015),
        Employee("Jane", "Wilson", 2010),
        Employee("Mike", "Jones", 2002),
    )

    findByLastName(employees, "Wilson")
    findByLastName(employees, "WilsonNotFound")

    //**** use label to clarify which lambda "this" we are referring to
    "some string".apply somestring@ {
        val thisString = this
        "another string".apply {
            // We can use a label to achieve the same as creating thisString variable
            println(thisString.lowercase())
            println(this@somestring.lowercase())
            println(this.uppercase())

        }
    }
}