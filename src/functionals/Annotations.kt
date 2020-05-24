package functionals

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation


annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    fun trim(){}
    fun fertilize(){}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

/*
    Prints all the methods in a class. Use [::class] to get information about a class at
    runtime. Use [declaredMemberFunctions] to get a list of the methods of a class.
    (To access this, you need to import kotlin.reflect.full.*)
 */
fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.declaredMemberFunctions) {
        println(m.name)
    }

    val plantObject = Plant::class
    for (a in plantObject.annotations) {
        println(a.annotationClass.simpleName)
    }

    val myAnnotationObject = plantObject.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outerLoop  // breaks to outer loop
        }
    }
    println("End labels")
}

fun main() {
    testAnnotations()
    // result : fertilize
    //          trim
    //          ImAPlant
    //          @functionals.ImAPlant()

    labels()
}