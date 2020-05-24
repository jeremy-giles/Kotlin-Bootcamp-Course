package generics

/*
    Kotlin, like many programming languages, has generic types. A generic type allows you
    to make a class generic, and thereby make a class much more flexible.
    Imagine you were implementing a [MyList] class that holds a list of items. Without
    generics, you would need to implement a new version of [MyList] for each type: one for
    [Double], one for [String], one for [Fish]. With generics, you can make the list generic, so
    it can hold any type of object. It's like making the type a wildcard that will fit many
    types.
    To define a generic type, put T in angle brackets [<T>] after the class name. (You could
    use another letter or a longer name, but the convention for a generic type is T.)

    You can reference [T] as if it were a normal type. The return type for [get()] is [T], and
    the parameter to [addItem()] is of type [T]. Of course, generic lists are very useful, so
    the [List] class is built into Kotlin.
 */
class MyList<T> {
    fun get(pos: Int): T {
        TODO("implement")
    }
    fun addItem(item: T) {}
}

fun main() {

}