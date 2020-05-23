package classes

/*
    The more compact Kotlin way is to define the properties directly with the constructor,
    using var or val, and Kotlin also creates the getters and setters automatically.
    Then you can remove the property definitions in the body of the class.

    Under the hood, Kotlin automatically creates getters and setters for the properties
    you defined in the [Aquarium] class, so you can access the properties directly, for
    example, [myAquarium.length]

    If your constructor needs more initialization code, it can be placed in one or more
    init blocks.
    Notice that the init blocks are executed in the order in which they appear in the
    class definition, and all of them are executed when the constructor is called.

    In addition to a primary constructor, which can have one or more init blocks, a Kotlin
    class can also have one or more secondary constructors to allow constructor overloading,
    that is, constructors with different arguments.

    Member variables
    [public] means visible outside the class. Everything is public by default, including
    variables and methods of the class.
    [internal] means it will only be visible within that module. A module is a set of
    Kotlin files compiled together, for example, a library or application.
    [private] means it will only be visible in that class (or source file if you are
    working with functions).
    [protected] is the same as [private], but it will also be visible to any subclasses.

    Properties within a class, or member variables, are public by default. If you define
    them with var, they are mutable, that is, readable and writable. If you define them
    with val, they are read-only after initialization.
    If you want a property that your code can read or write, but outside code can only read,
    you can leave the property and its getter as public and declare the setter private.
 */
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        private set(value) {
            height = (value * 1000) / (width * length)
        }

    init {
        println("aquarium initializing")
    }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        println("Volume: $volume l")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()

    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}