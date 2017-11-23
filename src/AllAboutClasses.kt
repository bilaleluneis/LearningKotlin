/**
 * @author Bilal El Uneis
 * @since Nov 20, 2017
 * bilaleluneis@gmail.com
 */


/**
 * NOTES:
 * - by default a class is final and cant be extended.
 * - by default a class is public.
 * - cant create protected class inside a file!!!
 */

class AllAboutClasses // this is actually a valid class def in Kotlin

class CantInheritMe{

    init {
        println("Instance of CantInheritMe created!")
    }

}

// bellow if uncommented will throw compile time error that CantInheritMe is final by default
// and thus can not be inherited !
/*
class TryToInherit : CantInheritMe() {

}*/

open class Base  // this class is open and can be extended

class ChildA : Base()

//public class that is final with private default constructor and public secondary constructor
class ClassWithPrivateDefaultConstructor private constructor(){

    //this is secondary constructor that can be used and is default to public access
    constructor(instanceName: String) : this() {
        println("new Instance of ClassWithPrivateDefaultConstructor with name $instanceName")
    }

    // this init is private because i declared default constructor as private
    init{
        println("ClassWithPrivateDefaultConstructor private init called!")
    }

}


fun main(args: Array<String>) {

    val allAboutClasses = AllAboutClasses()
    val cantInheritMe = CantInheritMe()
    val childA : Base = ChildA() //childA is constant of type Base assigned to instance of ChildA()
    val privateConstructorObject = ClassWithPrivateDefaultConstructor("duh")

}