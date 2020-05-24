package functionals

import com.sun.tools.corba.se.idl.Util.capitalize

data class Bird (var name: String)

fun birdExamples() {
    val bird = Bird("woody")  // all lowercase
    with (bird.name) {
        println(capitalize()) // Woody
    }
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main() {
    birdExamples()

    val bird = Bird("eddy")
    myWith (bird.name) {
        println(length) // 4
    }

    /*
        The [apply()] function is similar to [run()], but it returns the changed object it
        was applied to instead of the result of the lambda. This can be useful for calling
        methods on a newly created object.
     */
    val bird2 = Bird(name = "splashy").apply {
        name = "sharky"
    }
    println(bird2.name) // sharky
}
