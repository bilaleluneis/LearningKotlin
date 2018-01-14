package basics.classes

/**
 * @author Bilal El Uneis
 * @since Jan 12, 2018
 * bilaleluneis@gmail.com
 */

open class Person (name: String = "")

class PersonalInfo(pName: String, age: Int) : Person(pName)

/**
 *
 */
class PrivateConstructor private constructor() : Person() {

    constructor(message: String) : this() {
        println("Initialized with message $message")
    }

    init{
        print("init called .. this is the default Constructor made private")
    }

}

fun main(args: Array<String>) {

}