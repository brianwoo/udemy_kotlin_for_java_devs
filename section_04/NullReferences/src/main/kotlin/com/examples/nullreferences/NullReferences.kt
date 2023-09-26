package com.examples.nullreferences

fun main(args: Array<String>) {

    //**** Nullable type like in Typescript (? is null-safe operator)
    val str: String? = null
    println("String is null but no exception? ${str?.uppercase()}")

    //**** Safe calls operator ?.
    // Safe calls operator can simplify nested checks scenarios in Java
    // val countryCode: String? = bank?.address?.country?.countryCode
    // countryCode assigned to null if bank is null, no NullPointerException thrown

    //**** Elvis operator ?:
    // If left side is not null, return left side, return right side otherwise.
    // This is like ?? in Typescript
    val str2 = str ?: "This is the default value"
    println("str with Elvis operator: $str2")

    //**** Safe cast operator as?
    val anyArray: Any = arrayOf(1,2,3)
    // Safe cast so that str3 is assigned to null and no Exception thrown
    val str3 = anyArray as? String
    println("Safe cast to null? ${str3?.uppercase()}")

    //**** Not null assertion / null checks (!!)
    // This is like ! in Typescript
    val notNullStr: String? = "sure not null"
    // Using !! to tell compiler we are sure notNullStr is not null.
    // But if it's null, it will throw a KotlinNullPointException
    val str4: String = notNullStr!!.uppercase()

    // Nullable type and Non-Nullable type are two different thing
    // Not allowed to assign a nullable variable to a non-nullable variable

    //**** let operator
    val notNullStr2: String? = "not null2"
    notNullStr2?.let { printText(it) }

    // The let operator is equivalent to:
    // if (notNullStr2 != null) {
    //     printText(notNullStr2)
    // }

    //**** == is a null-safe operator
    // We can compare between null and non-null variables
    // Kotlin made it simple so we don't have to do ?==
    val str5: String? = null
    val anotherStr = "blahblah"
    println(str5 == anotherStr)

    //**** Array of Nulls
    // Recall Kotlin doesn't allow Array(5) without initial values
    // Use arrayOfNulls if we really want that
    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts) {
        println(i)
    }
}

fun printText(text: String) {
    println(text)
}