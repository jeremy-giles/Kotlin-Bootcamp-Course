package functions

/*
    A lambda is an expression that makes a function. But instead of declaring a named
    function, you declare a function that has no name. Part of what makes this useful is
    that the lambda expression can now be passed as data. In other languages,
    lambdas are called [anonymous functions], [function literals], or similar names.
 */
/*
    Like named functions, lambdas can have parameters. For lambdas, the parameters
    (and their types, if needed) go on the left of what is called a function arrow [->].
    The code to execute goes to the right of the function arrow. Once the lambda is
    assigned to a variable, you can call it just like a function.
 */
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
/*
    What the code says:
        - Make a variable called [waterFilter].
        - [waterFilter] can be any function that takes an [Int] and returns an [Int].
        - Assign a lambda to [waterFilter].
        - The lambda returns the value of the argument [dirty] divided by 2.

    Note that you don't have to specify the type of the lambda argument anymore.
    The type is calculated by [type inference].
 */

/*
    So far, the examples for lambdas look mostly like functions. The real power of lambdas
    is using them to create higher-order functions, where the argument to one function
    is another function.

    Write a higher-order function. Here's a basic example, a function that takes two
    arguments. The first argument is an integer. The second argument is a function
    that takes an integer and returns an integer.
 */
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

/*
    To specify the argument as a regular function, use the [::] operator.
    This way Kotlin knows that you are passing the function reference as an argument,
    not trying to call the function.
 */
fun increaseDirty( start: Int ) = start + 1

fun main() {
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter2))

    println(updateDirty(15, ::increaseDirty))

    /*
        Note: Kotlin prefers that any parameter that takes a function is the last parameter.
        When working with higher-order functions, Kotlin has a special syntax, called the
        last parameter call syntax, which lets you make the code even more concise.
        In this case, you can pass a lambda for the function parameter, but you don't
        need to put the lambda inside the parentheses.
     */
    var dirtyLvl = 30
    dirtyLvl = updateDirty(dirtyLvl) { dirtyLvl -> dirtyLvl + 12}
    println(dirtyLvl)
}