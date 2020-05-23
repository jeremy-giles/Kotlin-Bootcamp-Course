package extensions

/*
    It's very common to write utility functions to extend the behavior of a class. Kotlin
    provides a convenient syntax for declaring these utility functions: extension functions.

    Extension functions allow you to add functions to an existing class without having to
    access its source code.

    Note: Extension functions only have access to the public API of the class they're
    extending. Variables that are private can't be accessed.

    Note: Extension functions are resolved statically, at compile time, based on the type
    of the variable.
 */

/*
    The function name is prefixed with the class it operates on. Inside the function,
    this refers to the object it is called on, and it refers to the iterator in the find()
    call.
 */
fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}
// OR fun String.hasSpaces() = find { it == ' ' } != null

fun main() {
    println("Does it have spaces?".hasSpaces()) // true

    // limitations of extensions
    val plant = GreenLeafyPlant(size = 10)
    plant.print()           // GreenLeafyPlant
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()   // AquariumPlant
}

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

/*
    In addition to extension functions, Kotlin also lets you add extension properties.
    Like extension functions, you specify the class you're extending, followed by a dot,
    followed by the property name.
 */
val AquariumPlant.isGreen: Boolean
    get() = color == "green"


/*
    Know about nullable receivers

    The class you extend is called the receiver, and it is possible to make that class
    nullable. If you do that, the [this] variable used in the body can be [null], so make sure
    you test for that. You would want to take a nullable receiver if you expect that callers
    will want to call your extension method on nullable variables, or if you want to provide
    a default behavior when your function is applied to [null].
 */
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
/*
    val plant: AquariumPlant? = null
    plant.pull()
    // In this case, there is no output when you run the program. Because plant is null,
    // the inner println() is not called.
 */