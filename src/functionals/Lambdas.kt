package functionals

val waterFilter = { dirty: Int -> dirty / 2 }

data class Fish(val name: String)
val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))

fun main() {
    println(waterFilter(30))
    // 15

    println(myFish.filter { it.name.contains("i")})
    // [Fish(name=Flipper), Fish(name=Moby Dick)]

    println(myFish.filter { it.name.contains("i")}.joinToString(", ") { it.name })
    // Flipper, Moby Dick
}