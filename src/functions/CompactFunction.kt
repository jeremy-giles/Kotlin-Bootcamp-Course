package functions

import java.util.*

/*
    "Compact functions", which can make your code more concise and readable, and can reduce
    the number of code paths for testing.
    Compact functions are also called "single-expression functions".
 */
/*
    It is best practice to put parameters without defaults first, and the ones with defaults after.
 */
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

/*
    Use a when expression without an argument, which in Kotlin acts as a series of
    if/else if checks.
 */
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) ->  true
        else -> false
    }
}
/*
    Compact functions, or single-expression functions, are a common pattern in Kotlin.
    When a function returns the results of a single expression, you can specify the body
    of the function after an [=] symbol, omit the curly braces [{}], and omit the [return].
 */
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun main() {
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter

    val day = randomDay()
    println("Change water: ${shouldChangeWater(day)}")
}