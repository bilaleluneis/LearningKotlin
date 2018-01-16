package basics.classes

/**
 * @author Bilal El Uneis
 * @since Jan 12, 2018
 * bilaleluneis@gmail.com
 */

class A(name: String)

class B constructor(name:String) // this is another way to write the above

/**
 * Example of class with init, private and public constructors
 * that are stand alone and also call other constructors
 */
class C {

    init {
        println("init() called on new instance of class C!")
    }

    private constructor() {
        println("instance of class C private constructor() called !")
    }

    constructor(id: String) {
        println("create instance of class C with constructor(id: String) id = $id !")
    }

    constructor(instanceNum: Int) : this() {
        println("constructor(instanceNum: Int) create instance of class C instanceNum = $instanceNum!")
    }

    constructor(id: String, instanceNum: Int) : this(id) {
        println("constructor(id: String, instanceNum: Int) for instance of Class C called!")
    }

}

/**
 * Example with private constructor on class blue print
 */
class D private constructor(instanceNum: Int) {

    constructor(id: String, instanceNum: Int) : this(instanceNum) {
        println("create instance of class D with id = $id and instanceNum = $instanceNum !")
    }

    private constructor() : this(0) {
        println("This should not be called !")
    }


    init {
        println("init() called on new instance of class D!")
    }
}



fun main(args: Array<String>) {

    A("instance of A")
    B("instance of B")
    C("C1")
    C(1)
    C("C2", 2)
    D("D1", 1)

}