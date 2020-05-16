package basics

// Type or paste the following expressions below into the REPL
// Tools -> Kotlin -> Kotlin REPL
// And press play button or press Control+Enter (Command+Enter on a Mac) to run the code

/*
    Practice using types
    Kotlin does not implicitly convert between number types, so you can't assign a [short] value directly to a [long] variable,
    or a [Byte] to an [Int]. This is because implicit number conversion is a common source of errors in programs. You can always
    assign values of different types by casting.
*/
/*
    // Define a variable of type [Int]
    val i: Int = 6

    // Create a new variable, then enter the variable name shown above, followed by [.to] function
    // IntelliJ IDEA displays a list of possible completions. This auto-completion works for variables
    // and objects of any type
    val b1 = i.toByte()
    println(b1)
    // result : 6

    // Assign a [Byte] value to variables of different types
    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)
    // result : 1

    val i1: Int = b2
    // result : error: type mismatch: inferred type is Byte but Int was expected

    val i2: String = b2
    // result : error: type mismatch: inferred type is Byte but String was expected

    val i3: Double = b2
    // result : error: type mismatch: inferred type is Byte but Double was expected

    // For the assignments that returned errors, try casting them instead
    val i4: Int = b2.toInt() // OK!
    println(i4)
    // result : 1

    val i5: String = b2.toString()
    println(i5)
    // result : 1

    val i6: Double = b2.toDouble()
    println(i6)
    // result : 1.0


    // To make long numeric constants more readable, Kotlin allows you to place underscores in the numbers,
    // where it makes sense to you. Try entering different numeric constants.
    val oneMillion = 1_000_000
    print(oneMillion)
    // result : 1000000

    val socialSecurityNumber = 999_99_9999L
    print(socialSecurityNumber)
    // result : 999999999

    val hexBytes = 0xFF_EC_DE_5E
    print(hexBytes)
    // result : 4293713502

    val bytes = 0b11010010_01101001_10010100_10010010
    print(bytes)
    // result : 3530134674
*/

/*
    Learn the value of variable types
    Kotlin supports two types of variables: changeable and unchangeable. With [val], you can assign a
    value once. If you try to assign something again, you get an error. With [var], you can assign a value,
    then change the value later in the program.
*/
/*
    var fish = 1
    fish = 2
    print(fish)
    // result : 2

    val aquarium = 1
    aquarium = 2
    // result : val cannot be reassigned

    // The type you store in a variable is inferred when the compiler can figure it out from context.
    // If you want, you can always specify the type of a variable explicitly, using the colon notation.
    // Once a type has been assigned by you or the compiler, you can't change the type, or you get an error.
    var fish : Int = 1
    fish = 1.0
    // result : the floating-point literal does not conform to the expected type Int
*/

/*
    Learn about strings
    Strings in Kotlin work pretty much like strings in any other programming language using ["] for strings
    and ['] for single characters, and you can concatenate strings with the + operator. You can create string templates
    by combining them with values; the $variable name is replaced with the text representing the value. This is
    called variable interpolation.
*/
/*
    // String template
    val numberOfFish = 5
    val numberOfPlants = 12
    "I have $numberOfFish fish" + " and $numberOfPlants plants"
    // res1: kotlin.String = I have 5 fish and 12 plants

    // String template with an expression in it
    val numberOfFish = 5
    val numberOfPlants = 12
    "I have ${numberOfFish + numberOfPlants} fish and plants"
    // res2: kotlin.String = I have 17 fish and plants
*/