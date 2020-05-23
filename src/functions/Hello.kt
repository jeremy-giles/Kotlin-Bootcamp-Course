package functions

/*
To run your program, click the green triangle to the left of the main() function.
Select Run 'HelloKt' from the menu.
 */
fun main(args: Array<String>) {
    println("Hello, world!")

    /*
        Select Run > Edit Configurations. The Run/Debug Configurations window opens.
        Type "Kotlin!" in the Program arguments field.
        Click OK.
     */
    //println("Hello, ${args[0]}")

    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)
    // result : This is an expression
    //          kotlin.Unit

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val temperature2 = 10
    val message = "The water temperature is ${ if (temperature2 > 50) "too warm" else "OK" }."
    println(message)
}
/*
    Note: When a function returns kotlin.Unit, you don't have to specify it explicitly.
    This is different from some other languages, where you have to explicitly say that you
    are returning nothing.

    Note: Loops are exceptions to "everything has a value." There's no sensible value
    for for loops or while loops, so they do not have values. If you try to assign a
    loop's value to something, the compiler gives an error.
 */