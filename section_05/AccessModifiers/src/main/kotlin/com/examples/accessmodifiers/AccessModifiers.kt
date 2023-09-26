package com.examples.accessmodifiers

//**** Top-Level Items
// private:
// - Kotlin: Visible within the same file
// - Java: Can't declare top-level a private class
//
// protected:
// - Kotlin: Can't be used
// - Java: Can't be used
//
// public:
// - Kotlin: Visible everywhere
// - Java: Visible everywhere
//
// internal:
// - Visible within the same module
// - N/A


//**** Constant can be at top level, not inside a class
val MY_CONSTANT = 100

fun main() {

    //**** Kotlin: private classes that are accessible, if in same file
    val emp = PrivateEmployee()
    println(emp)

    val emp1 = Employee("John")
    println("Employee 1st ctor: ${emp1.firstName}")
    println("Employee 1st ctor: ${emp1.fullTime}")
    emp1.fullTime = false
    println("Employee 1st ctor, after changing fullTime: ${emp1.fullTime}")

    val emp2 = Employee("Jane", false)
    println("Employee 2nd ctor: ${emp2.firstName}")
    println("Employee 2nd ctor: ${emp2.fullTime}")

    val emp3 = EmployeeDefaultValue("Jing")
    println("EmployeeDefaultValue: ${emp3.firstName}")
    println("EmployeeDefaultValue: ${emp3.fullTime}")
    println("EmployeeDefaultValue: ${emp3.internal}")

    val emp4 = EmployeeCustomGetterSetter("Jones", false)
    println("EmployeeCustomGetterSetter: ${emp4.firstName}")
    println("EmployeeCustomGetterSetter: ${emp4.fullTime}")
    emp4.fullTime = true
    println("EmployeeCustomGetterSetter after custom set: ${emp4.fullTime}")
}

//**** Top level class, Kotlin can have a private class, not for Java
private class PrivateEmployee {
}

//**** Kotlin: classes are public final by default
//**** Kotlin: primary constructor (outside of the {}), *this is the long way*
class EmployeeLongWay constructor(firstName: String) {
    val firstName: String

    // initializer block
    init {
        this.firstName = firstName
    }
}

//**** Kotlin: primary constructor without init block, *Shorter way*
class EmployeeShorterWay constructor(firstName: String) {
    val firstName: String = firstName
}

//**** Kotlin: primary constructor without init block and assignment, *Shortest way*
class Employee(val firstName: String) {

    var fullTime: Boolean = true

    //**** secondary constructor
    constructor(firstName: String, fullTime: Boolean): this(firstName) {
        this.fullTime = fullTime
    }
}

//**** Default value parameter support in Kotlin
//**** Kotlin auto generates getters and setters for properties
class EmployeeDefaultValue(val firstName: String, var fullTime: Boolean = true) {

    var internal: Boolean = false

    constructor(firstName: String, fullTime: Boolean, internal: Boolean = true): this(firstName, fullTime) {
        this.internal = internal
    }
}

// Demo class with no primary constructor
class Demo {

    val dummy: String

    constructor(dummy: String) {
        this.dummy = dummy
    }
}

//**** Defining custom getter/setter
class EmployeeCustomGetterSetter(val firstName: String, fullTime: Boolean = true) {

    //**** getter/setter NEEDS to come RIGHT AFTER the field declaration
    //**** Use the "field" identifier in the getter/setter to refer to the backing property
    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
        }
}


