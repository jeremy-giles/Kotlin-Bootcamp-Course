package basics

// Type or paste the following expressions below into the REPL
// Tools -> Kotlin -> Kotlin REPL
// And press play button or press Control+Enter (Command+Enter on a Mac) to run the code

/*
    Compare conditions and booleans
    Like other languages, Kotlin has booleans and boolean operators such as less than, equal to, greater than,
    and so on (<, ==, >, !=, <=, >=).
*/
/*
    // If / Else statement
    val numberOfFish = 50
    val numberOfPlants = 23
    if (numberOfFish > numberOfPlants) {
        println("Good ratio!")
    } else {
        println("Unhealthy ratio")
    }
    // result : Good ratio!

    // Range in an if statement
    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }
    // result : 50

    // An if with multiple cases. For more complicated conditions, use logical and && and logical or ||.
    // As in other languages, you can have multiple cases by using else if.
    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }
    result : That's a lot of fish!

    // Like a [switch] in other languages Kotlin using [when] statement.
    // Conditions in a when statement can use ranges, too
    when (numberOfFish) {
        0  -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }
    // result : That's a lot of fish!
*/