package functions

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    println( decorations.filter {it[0] == 'p'})

    /*
        Is the result list created immediately, or when the list is accessed? In Kotlin, it happens
        whichever way you need it to. By default, [filter] is eager, and each time you use the filter, a list is created.

        To make the filter lazy, you can use a [Sequence], which is a collection that can
        only look at one item at a time, starting at the beginning, and going to the end.
        Conveniently, this is exactly the API that a lazy filter needs.
     */
    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")
    // result : eager: [pagoda, plastic plant]

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    // result : filtered: kotlin.sequences.FilteringSequence@6ce253f1

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    // result : lazy: kotlin.sequences.TransformingSequence@4c873330
    //          -----
    //          access: rock
    //          first: rock
    //          -----
    //          access: rock
    //          access: pagoda
    //          access: plastic plant
    //          access: alligator
    //          access: flowerpot
    //          all: [rock, pagoda, plastic plant, alligator, flowerpot]

    /*
        Printing [lazyMap] just prints a reference to the [Sequence]—the inner println()
        isn't called. Printing the first element accesses only the first element.
        Converting the [Sequence] to a [List] accesses all the elements.
     */

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
    // result : access: pagoda
    //          access: plastic plant
    //          filtered: [pagoda, plastic plant]
}