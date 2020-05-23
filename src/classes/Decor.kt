package classes

/*
    A data class is similar to a [struct] in some other languages—it exists mainly to hold
    some data—but a data class object is still an object. Kotlin data class objects have
    some extra benefits, such as utilities for printing and copying. In this task, you
    create a simple data class and learn about the support Kotlin provides for data classes.
 */

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

data class Decoration(val rocks: String)

data class Decoration2(val rocks: String, val wood: String, val diver: String)

/*
    A sealed class is a class that can be subclassed, but only inside the file in which
    it's declared. If you try to subclass the class in a different file, you get an error.

    Because the classes and subclasses are in the same file, Kotlin will know all the
    subclasses statically. That is, at compile time, the compiler sees all the classes
    and subclasses and knows that this is all of them, so the compiler can do extra
    checks for you.
    The Seal class can't be subclassed in another file. If you want to add more Seal types,
    you have to add them in the same file. This makes sealed classes a safe way to
    represent a fixed number of types.
 */
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println (decoration1.equals(decoration2)) // false
    println (decoration3.equals(decoration2)) // true

    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    // Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}

fun main() {
    makeDecorations()

    println(Direction.EAST.name)
    println(Direction.NORTH.ordinal)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}