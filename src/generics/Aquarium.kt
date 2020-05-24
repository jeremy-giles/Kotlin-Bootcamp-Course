package generics

open class WaterSupply(var needsProcessing: Boolean)

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

//class Aquarium<T>(val waterSupply: T)

// To not allow passing [null], make [T] of type [Any] explicitly, by removing the [?] after [Any].
//class Aquarium<T: Any>(val waterSupply: T)

// What you really want is to make sure that only a WaterSupply (or one of its subclasses)
// can be passed for T. Replace Any with WaterSupply to define a more specific generic
// constraint.
// [check()] function to help ensure your code is behaving as expected. The [check()] function
// is a standard library function in Kotlin. It acts as an assertion and will throw an
// [IllegalStateException] if its argument evaluates to [false].
class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }
}

/*
    Kotlin can ensure that addItemTo() won't do anything type unsafe with the generic
    WaterSupply, because it's declared as an out type.
    If you remove the out keyword, the compiler will give an error when calling addItemTo(),
    because Kotlin can't ensure that you are not doing anything unsafe with the type.

    Kotlin will use the the in and out type information to make sure your code uses the
    generics safely. Out and in are easy to remember: out types can be passed outward as
    return values, in types can be passed inward as arguments.
 */
class Aquarium2<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }

    //fun <R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
    // To do an [is] check, you need to tell Kotlin that the type is [reified], or real,
    // and can be used in the function. To do that, put [inline] in front of the [fun]
    // keyword, and [reified] in in front of the generic type [R].
    // Note: Generic types are normally only available at compile time, and get replaced
    // with the actual types. To keep a generic type available until run time, declare
    // the function [inline] and make the type [reified].
}

/*
    The in type is similar to the out type, but for generic types that are only ever passed
    into functions, not returned. If you try to return an in type, you'll get a compiler
    error. In this example you'll define an in type as part of an interface.
 */
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) =   waterSupply.addChemicalCleaners()
}

fun addItemTo(aquarium: Aquarium2<WaterSupply>) = println("item added")

/*
fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}
 */
/*
    This means [Aquarium] must have an [out] type parameter for this to be called. Sometimes
    [out] or [in] is too restrictive because you need to use a type for both input and output.
    You can remove the [out] requirement by making the function generic.

    To make the function generic, put angle brackets after the keyword [fun] with a generic
    type [T] and any constraints, in this case, [WaterSupply]. Change [Aquarium] to be constrained
    by [T] instead of by [WaterSupply].
 */

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}
/*
    [T] is a type parameter to [isWaterClean()] that is being used to specify the generic type of the
    aquarium. This pattern is really common, and it's a good idea to take a moment to work through this.
 */


/*
    Make an [Aquarium] and pass it a [WaterSupply]. Since the [waterSupply] parameter is
    generic, you must specify the type in angle brackets [<>].

    When creating the [Aquarium] object, you can remove the angle brackets and what's between
    them because Kotlin has type inference. So there's no reason to say [TapWater] twice when
    you create the instance. The type can be inferred by the argument to [Aquarium]; it will
    still make an [Aquarium] of type [TapWater].
 */
fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater()) // true
    // OR val aquarium = Aquarium(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners() // false
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    //val aquarium2 = Aquarium("string")
    //println(aquarium2.waterSupply) // string

    /*
    val aquarium3 = Aquarium(null)
    if (aquarium3.waterSupply == null) {
        println("waterSupply is null") // waterSupply is null
        // Why can you pass null when creating an Aquarium? This is possible because by
        // default, T stands for the nullable Any? type, the type at the top of the type
        // hierarchy.
        // class Aquarium<T: Any?>(val waterSupply: T) is equivalent
    }
     */

    val aquarium4 = Aquarium(LakeWater())
    //aquarium4.addWater() // Exception in thread "main" java.lang.IllegalStateException: water supply needs processing first
    aquarium4.waterSupply.filter()
    aquarium4.addWater() // adding water from generics.LakeWater@49476842
}

fun genericsExample2() {
    val aquarium = Aquarium2(TapWater())
    addItemTo(aquarium)

    val cleaner = TapWaterCleaner()
    val aquarium2 = Aquarium2(TapWater())
    aquarium2.addWater(cleaner)
}

fun genericsExample3() {
    val aquarium = Aquarium(TapWater())
    isWaterClean<TapWater>(aquarium)
    // OR Because of type inference from the argument aquarium, the type
    // isn't needed, so remove it
    // isWaterClean(aquarium)

    val aquarium2 = Aquarium2(TapWater())
    println(aquarium2.hasWaterSupplyOfType<TapWater>())   // true

    val aquarium3 = Aquarium2(TapWater())
    println(aquarium3.waterSupply.isOfType<TapWater>()) // true
}

fun main() {
    genericsExample()

    println("Part 2 (in/out)")
    genericsExample2()

    println("Part 3 (Generic function)")
    genericsExample3()
}