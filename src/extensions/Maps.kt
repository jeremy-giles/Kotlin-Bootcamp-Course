package extensions

fun main() {
    // You can then retrieve the disease value based on the symptom key, using [get()],
    // or even shorter, square brackets []
    val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots")) // Ich
    println(cures["red sores"]) // hole disease
    println(cures["scale loss"]) // null

    // If a key isn't in the map, trying to return the matching disease returns [null].
    // Depending on the map data, it may be common to have no match for a possible key.
    // For cases like that, Kotlin provides the [getOrDefault()] function.
    println(cures.getOrDefault("bloating", "sorry, I don't know"))

    // If you need to do more than just return a value, Kotlin provides the [getOrElse()] function.
    println(cures.getOrElse("bloating") {"No cure for this"})

    // Just like [mutableListOf], you can also make a [mutableMapOf]. A mutable map lets
    // you put and remove items. Mutable just means able to change, immutable means unable
    // to change.
    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    println(inventory.toString())
    inventory.remove("fish net")
    println(inventory.toString())
    // result : {fish net=1, tank scrubber=3}{tank scrubber=3}
}

/*
    const vs. val

    The value is assigned, and can't be changed, which sounds a lot like declaring a regular
    val. So what's the difference between const val and val? The value for const val is
    determined at compile time, where as the value for val is determined during program
    execution, which means, val can be assigned by a function at run time.
    That means val can be assigned a value from a function, but const val cannot.

    In addition, [const val] only works at the top level, and in singleton classes declared
    with [object], not with regular classes. You can use this to create a file or singleton
    object that contains only constants, and import them as needed.

    The basic difference between companion objects and regular objects is:
    Companion objects are initialized from the static constructor of the containing class,
    that is, they are created when the object is created.
    Regular objects are initialized lazily on the first access to that object; that is,
    when they are first used.
 */
class MyClass {
    companion object {
        const val CONSTANT = "constant in companion"
    }
}