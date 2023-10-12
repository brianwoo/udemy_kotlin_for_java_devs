package com.examples.lists

fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "fall", "winter")
    val colorList = listOf("black", "white", "red")

    //**** Get last element of a List
    println(strings.last())

    //**** Reverse a List
    println(strings.reversed())
    println(strings.asReversed())

//    if (strings.size > 5) {
//        println(strings[5])
//    }

    //**** Get Element at position Or Null
    println(strings.getOrNull(5))

    //**** Get max in a List
    val ints = listOf(1,2,3,4,5)
    println(ints.max())

    //**** Join 2 Lists together
    val mergedLists = colorList + strings
    println(mergedLists)

    //**** Join 2 Lists together, in Pairs
    println(colorList.zip(strings))

    //**** combining 2 lists with NO DUPLICATES
    val list1 = listOf("aaa", "bbb", "ccc", "ddd", "aaa")
    val list2 = listOf("111", "222", "333", "111")
    val noDupsList = list1.union(list2)
    println(noDupsList)

    //**** Remove duplicate items in a List
    val noDupList1 = list1.distinct()
    println(noDupList1)

    //**** List is immutable, to change to mutable
    val mutableList = noDupsList.toMutableList()
    mutableList.add("zzz")
    println(mutableList)
}