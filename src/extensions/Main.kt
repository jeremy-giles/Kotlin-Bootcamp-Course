package extensions

/*
    Pairs and triples are premade data classes for 2 or 3 generic items. This can, for
    example, be useful for having a function return more than one value.
 */

fun isFreshWater(fish: String) : Boolean {
    return fish.startsWith('p')
}

fun main() {
    val fishes = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    // List.partition() returns two lists, one with the items where the condition is true,
    // and the other for items where the condition is false
    val twoLists = fishes.partition { isFreshWater(it) }

    println("freshwater: ${twoLists.first}") // freshwater: [pagoda, plastic plant]
    println("saltwater: ${twoLists.second}") // saltwater: [rock, alligator, flowerpot]

    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}") // fish net used for catching fish

    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}\n") // (fish net, catching fish) is equipment
    println("${equipment2.first.second}") // catching fish

    /*
        Separating pairs and triples into their parts is called destructuring. Assign the
        pair or triple to the appropriate number of variables, and Kotlin will assign
        the value of each part in order.
     */
    val equipment3 = "fish net" to "catching fish"
    val (tool, use) = equipment3
    println("$tool is used for $use") // fish net is used for catching fish

    val numbers = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3") // 6 9 42
}