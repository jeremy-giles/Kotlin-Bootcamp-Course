package basics

// Type or paste the following expressions below into the REPL
// Tools -> Kotlin -> Kotlin REPL
// And press play button or press Control+Enter (Command+Enter on a Mac) to run the code

/*
    Learn about nullability
    Nullable versus non-nullable variables. Programming errors involving nulls have been the source
    of countless bugs. Kotlin seeks to reduce bugs by introducing non-nullable variables.
*/
/*
    // By default, variables cannot be [null]
    // Declare an [Int] and assign null to it
    var rocks: Int = null
    // result : error: null can not be a value of a non-null type Int

    // Use the question mark operator, [?], after the type to indicate that a variable can be null.
    // Declare an [Int?] and assign null to it
    var marbles: Int? = null
*/
/*
    // [?] and [?:] operators
    // Check whether the [fishFoodTreats] variable is not [null]. Then decrement that variable
    var fishFoodTreats = 6
    if (fishFoodTreats != null) {
        fishFoodTreats = fishFoodTreats.dec()
    }
    print(fishFoodTreats)
    // result : 5

    // Kotlin way to write it, using the [?] operator
    var fishFoodTreats = 6
    fishFoodTreats = fishFoodTreats?.dec()

    // Chain null tests with the ?: operator
    fishFoodTreats = fishFoodTreats?.dec() ?: 0
    // It's shorthand for "if fishFoodTreats is not null, decrement and use it; otherwise use the value after the [?:],
    // which is [0]." If fishFoodTreats is [null], evaluation is stopped, and the [dec()] method is not called.

    // Note: The ?: operator is sometimes called the "Elvis operator," because it's like a smiley on its side with a
    // pompadour hairstyle, the way Elvis Presley styled his hair.

    // Null pointers
    // If you really love [NullPointerExceptions], Kotlin lets you keep them.
    // The not-null assertion operator, [!!] (double-bang), converts any value to a non-null type and throws
    // an exception if the value is null.
    val i1 : Int? = null
    val i2 = s!!.inc()
    // result : kotlin.KotlinNullPointerException
*/
