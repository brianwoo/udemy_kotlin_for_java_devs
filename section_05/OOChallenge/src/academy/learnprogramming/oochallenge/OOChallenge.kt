package academy.learnprogramming.oochallenge

import academy.learnprogramming.javacode.MountainBike

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement;
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence" +
                    " travelling at a speed of $speed."
        )
    }
}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10):
    KotlinBicycle(cadence, speed, gear) {

    var color: String = ""

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10):
            this(seatHeight, cadence, speed, gear) {
        this.color = color
    }

    companion object {
        fun availableColors(): List<String> = listOf("blue", "red", "white", "black", "green", "brown")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
        println("The mountain bike has color $color.")
    }
}

class KotlinRoadBike(cadence: Int, speed: Int, val tireWidth: Int, gear: Int = 10):
    KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth mm.")
    }
}


fun main(args: Array<String>) {

    val kBike = KotlinBicycle(1,2)
    val kMountainBike = KotlinMountainBike(1,2,3)
    val kYellowMountainBike = KotlinMountainBike("yellow",1,2,3 )
    val kRoadBike = KotlinRoadBike(1,2,3)

    kBike.printDescription()
    kMountainBike.printDescription()
    kRoadBike.printDescription()

    kYellowMountainBike.printDescription()

    val availableColors = KotlinMountainBike.availableColors()
    println(availableColors.joinToString(", "))
}