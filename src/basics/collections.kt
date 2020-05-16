package basics

// Type or paste the following expressions below into the REPL
// Tools -> Kotlin -> Kotlin REPL
// And press play button or press Control+Enter (Command+Enter on a Mac) to run the code

/*
    Make lists
*/
/*
    // Declare a list using [listOf] and print it out. This list cannot be changed
    val school = listOf("mackerel", "trout", "halibut")
    println(school)
    // result : [mackerel, trout, halibut]

    // Declare a list that can be changed using [mutableListOf]. Remove an item
    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")
    // result : kotlin.Boolean = true
    // The [remove()] method returns [true] when it successfully removes the item passed.

    // Note : With a list defined with val, you can't change which list the variable refers to,
    // but you can still change the contents of the list.
*/

/*
    Create arrays
    Unlike lists in Kotlin, which have mutable and immutable versions, there is no mutable version
    of an [Array]. Once you create an array, the size is fixed. You can't add or remove elements,
    except by copying to a new array.

    The rules about using [val] and [var] are the same with arrays as with lists
*/
/*
    // Using [arrayOf]. Use the [java.util.Arrays.toString()] array utility to print it out.
    val school = arrayOf("shark", "salmon", "minnow")
    println(java.util.Arrays.toString(school))
    // result : [shark, salmon, minnow]

    // An array declared with arrayOf doesn't have a type associated with the elements,
    // so you can mix types, which is helpful. Declare an array with different types.
    val mix = arrayOf("fish", 2)
    println(java.util.Arrays.toString(mix))
    // result : [fish, 2]

    // Declare arrays with one type for all the elements.
    // Declare an array of integers using [intArrayOf()]. There are corresponding builders, or instantiation
    // functions, for arrays of other types.
    val numbers = intArrayOf(1,2,3)

    // Combine two arrays with the [+] operator
    val numbers = intArrayOf(1,2,3)
    val numbers3 = intArrayOf(4,5,6)
    val foo2 = numbers3 + numbers
    println(foo2[5])
    // result : 3

    // Different combinations of nested arrays and lists.
    // As in other languages, you can nest arrays and lists. That is, when you put an array within an array,
    // you have an array of arrays—not a flattened array of the contents of the two. The elements of an
    // array can also be lists, and the elements of lists can be arrays.
    val numbers = intArrayOf(1, 2, 3)
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers, oceans, "salmon")
    println(oddList)
    // result : [[I@11a481f4, [Atlantic, Pacific], salmon]
    // The first element, numbers, is an Array. When you don't use the array utility to print it, Kotlin prints the
    // address instead of the contents of the array.

    // Initialize arrays with code instead of initializing them to 0
    val array = Array (5) { it * 2 }
    println(java.util.Arrays.toString(array))
    // result : [0, 2, 4, 6, 8]
*/

/*
    Make loops
*/
/*
    // Use a [for] loop to iterate through the array and print the elements.
    val school = arrayOf("shark", "salmon", "minnow")
    for (element in school) {
        print(element + " ")
    }
    // result : shark salmon minnow

    // In Kotlin, you can loop through the elements and the indexes at the same time.
    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element\n")
    }
    // result : Item at 0 is shark
    //          Item at 1 is salmon
    //          Item at 2 is minnow

    // Different step sizes and ranges. You can specify ranges of numbers or of characters,
    // alphabetically. And as in other languages, you don't have to step forward by 1. You can step
    // backward using [downTo]
    for (i in 1..5) print(i)
    // result : 12345

    for (i in 5 downTo 1) print(i)
    // result : 54321

    for (i in 3..6 step 2) print(i)
    // result : 35

    for (i in 'd'..'g') print (i)
    // result : defg

    // Like other languages, Kotlin has [while] loops, [do...while] loops, and [++] and [--] operators.
    // Kotlin also has [repeat] loops.
    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    // result : 50 bubbles in the water
    //          49 bubbles in the water

    repeat(2) {
        println("A fish is swimming")
    }
    // result : A fish is swimmingA fish is swimming
*/