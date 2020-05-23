package classes

import java.lang.Math.PI

/*
    In Kotlin, by default, classes cannot be subclassed. Similarly, properties and member
    variables cannot be overridden by subclasses (though they can be accessed).
    You must mark a class as [open] to allow it to be subclassed. Similarly, you must mark
    properties and member variables as [open], in order to override them in the subclass.
    The [open] keyword is required, to prevent accidentally leaking implementation details
    as part of the class's interface.
 */

open class Aquarium2(
        open var length: Int = 100,
        open var width: Int = 20,
        open var height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("aquarium initializing")
    }

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

fun buildAquarium2() {
    val aquarium = Aquarium2(length = 25, width = 25, height = 40)
    aquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

class TowerTank (
        override var height: Int,
        var diameter: Int
): Aquarium2(height = height, width = diameter, length = diameter) {

    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"
}


fun main() {
    buildAquarium2()
}