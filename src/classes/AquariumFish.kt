package classes

/*
    Sometimes you want to define common behavior or properties to be shared among some
    related classes. Kotlin offers two ways to do that, interfaces and abstract classes.
    In this task, you create an abstract AquariumFish class for properties that are common
    to all fish. You create an interface called FishAction to define behavior common to
    all fish.

    - Neither an abstract class nor an interface can be instantiated on its own, which
    means you cannot create objects of those types directly.
    - Abstract classes have constructors.
    - Interfaces can't have any constructor logic or store any state.

    Note: Abstract classes are always open; you don't need to mark them with open.
    Properties and methods of an abstract class are non-abstract unless you explicitly
    mark them with the abstract keyword. That means subclasses can use them as given.
    If properties or methods are abstract, the subclasses must implement them.
 */

abstract class AquariumFish {
    abstract val color: String
}

interface FishAction  {
    fun eat()
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Shark: AquariumFish(), FishAction {
    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: FishColor, FishAction {
    override val color = "gold"

    override fun eat() {
        println("eat algae")
    }
}

class Bar(fishColor: FishColor = GoldColor) :
        FishAction by PrintingFishAction("eat bread"),
        FishColor by fishColor

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()

    val bar = Bar()
    println("Bar: ${bar.color}")
    bar.eat()
}

fun main () {
    makeFish()
}